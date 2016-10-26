package com.jju.yuxin.voiceassistant.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUnderstander;
import com.iflytek.cloud.SpeechUnderstanderListener;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;
import com.iflytek.sunflower.FlowerCollector;
import com.jju.yuxin.voiceassistant.parser.JsonParser;
import com.jju.yuxin.voiceassistant.R;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.parser.ParserReturnBean;

import static android.util.Log.e;

public class MainActivity extends Activity {

    private static String TAG = MainActivity.class.getSimpleName();
    // 语义理解对象（语音到语义）。
    private SpeechUnderstander mSpeechUnderstander;
    // 语义理解对象（文本到语义）。
    private TextUnderstander mTextUnderstander;

    //话筒按钮
    private Button start_understander;

    //帮助按钮
    private Button bt_help;

    //识别的文字信息
    private TextView spech_text;

    //回答
    public TextView answer_text;

    private ReturnBean returnBean;

    //*********************语音合成***************************//
    // 语音合成对象
    public SpeechSynthesizer mTts;
    // 默认发音人
    private String voicer = "nannan";
    // 缓冲进度
    private int mPercentForBuffering = 0;
    // 播放进度
    private int mPercentForPlaying = 0;

    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;

    private Toast mToast;
    private SharedPreferences mSharedPreferences;

    //网页显示
    public WebView wb_result;

    private ScrollView scrollView;

    private ImageView iv_loding;

    private AnimationDrawable animationDrawable;

    @SuppressLint("ShowToast")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=YOUR APP KEY");
        initLayout();
        /**
         * 申请的appid时，我们为开发者开通了开放语义（语义理解）
         * 由于语义理解的场景繁多，需开发自己去开放语义平台：http://www.xfyun.cn/services/osp
         * 配置相应的语音场景，才能使用语义理解，否则文本理解将不能使用，语义理解将返回听写结果。
         */
        // 初始化对象
        mSpeechUnderstander = SpeechUnderstander.createUnderstander(MainActivity.this, mSpeechUdrInitListener);
        mTextUnderstander = TextUnderstander.createTextUnderstander(MainActivity.this, mTextUdrInitListener);
        mToast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);

        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(MainActivity.this, mTtsInitListener);

    }

    int ret = 0;// 函数调用返回值

    /**
     * 初始化Layout。
     */
    private void initLayout() {
        //话筒按钮
        start_understander = (Button) findViewById(R.id.start_understander);
        //帮助按钮
        bt_help = (Button) findViewById(R.id.bt_help);
        //说话内容
        spech_text = (TextView) findViewById(R.id.spech_text);
        //回答内容
        answer_text = (TextView) findViewById(R.id.answer_text);
        //网页内容
        wb_result = (WebView) findViewById(R.id.wb_result);
        //wb_result.setVisibility(View.INVISIBLE);
        //加载动画
        iv_loding=(ImageView) findViewById(R.id.iv_loding);

        iv_loding.setVisibility(View.GONE);

        animationDrawable = (AnimationDrawable) iv_loding.getBackground();

        //触摸监听
        start_understander.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //不管有没有显示,先让其消失
                        wb_result.setVisibility(View.GONE);
                        //让承载动画的控件显示
                        iv_loding.setVisibility(View.VISIBLE);
                        //动画开始
                        animationDrawable.start();
                        // 设置参数
                        setParam();
                        /**
                         * 当按键按下时停止说话,不管你有没有说
                         */
                        mTts.stopSpeaking();
                        answer_text.setText("");
                        if (mSpeechUnderstander.isUnderstanding()) {// 开始前检查状态
                            mSpeechUnderstander.stopUnderstanding();
                            showTip("无法识别语音内容...");
                            //出现异常
                            answer_text.setText("抱歉,没有连接到互联网,无法使用语音助手!");
                            //将返回内容读出来
                            int code = mTts.startSpeaking("连接好像出现了问题,待会再试吧!", mTtsListener);
                            //出现异常
                            if (code != ErrorCode.SUCCESS) {
                                Toast.makeText(MainActivity.this, "语音合成失败,错误码: " + code, Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            ret = mSpeechUnderstander.startUnderstanding(mSpeechUnderstanderListener);
                            if (ret != 0) {
                                showTip("语义理解失败!" );
                                e(TAG, "onTouch" + "语义理解失败,错误码:" + ret);
                            } else {
                              //  showTip(getString(R.string.text_begin));
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:

                        animationDrawable.stop();
                        //让承载动画的控件消失
                        iv_loding.setVisibility(View.GONE);

                        spech_text.setFocusable(true);
                        spech_text.setFocusableInTouchMode(true);
                        spech_text.requestFocus();

                        mSpeechUnderstander.stopUnderstanding();
                     //   showTip("停止语义理解");
                        FlowerCollector.onEvent(MainActivity.this, "tts_play");
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

        bt_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent help_Intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(help_Intent);
            }
        });
        mSharedPreferences = getSharedPreferences("com.iflytek.setting", Activity.MODE_PRIVATE);
    }

    /**
     * 初始化监听器（语音到语义）。
     */
    private InitListener mSpeechUdrInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "speechUnderstanderListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                e(TAG, "onInit" + "语音到语义初始化失败,错误码：" + code);
               // showTip("语音到语义初始化失败,错误码：" + code);
            }
        }
    };

    /**
     * 初始化语音合成监听。
     */
    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d(TAG, "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                e(TAG, "onInit" + "语音合成初始化失败,错误码：" + code);
              //  showTip("语音合成初始化失败,错误码：" + code);
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };

    /**
     * 初始化监听器（文本到语义）。
     */
    private InitListener mTextUdrInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "textUnderstanderListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                e(TAG, "onInit" + "文本到语义初始化失败,错误码：" + code);
             //   showTip("文本到语义初始化失败,错误码：" + code);
            }
        }
    };

    /**
     * 文本语义理解回调。
     */
    private TextUnderstanderListener mTextUnderstanderListener = new TextUnderstanderListener() {

        @Override
        public void onResult(final UnderstanderResult result) {
            if (null != result) {
                // 显示
                String text = result.getResultString();
                if (!TextUtils.isEmpty(text)) {
                    e(TAG, "文本语义理解回调onResult:" + text);
                }
            } else {
                Log.d(TAG, "understander result:null");
              //  showTip("识别结果不正确。");
            }
        }

        @Override
        public void onError(SpeechError error) {
            // 文本语义不能使用回调错误码14002，请确认您下载sdk时是否勾选语义场景和私有语义的发布
            e(TAG, "onError Code：" + error.getErrorCode());
          //  showTip("onError Code：" + error.getErrorCode());
        }
    };

    /**
     * 语音语义理解回调。
     */
    private SpeechUnderstanderListener mSpeechUnderstanderListener = new SpeechUnderstanderListener() {

        @Override
        public void onResult(final UnderstanderResult result) {
            if (null != result) {
                Log.d(TAG, result.getResultString());
                // 显示
                String text = result.getResultString();
                if (!TextUtils.isEmpty(text)) {
                    /**
                     * 传入返回的json解析成对象
                     */
                    e(TAG, "语音语义理解回调onResult:" + text);
                    //传入json数据,返回解析完成的对象
                    returnBean = JsonParser.parseIatResult(text);
                    //获取说的话内容
                    spech_text.setText(returnBean.getText());
                    //应答码为0,表示操作正常
                    if (returnBean.getRc() == 0) {
                        //解析对象,分析语义场景
                        ParserReturnBean.parserOsp(MainActivity.this, returnBean);
                    } else if(returnBean.getRc() == 4){
                        answer_text.setText("我好像还不能理解你说话的内容,是不是有点蠢蠢哒!");
                        //将返回内容读出来
                        int code = mTts.startSpeaking("我好像还不能理解你说话的内容,是不是有点蠢蠢哒!", mTtsListener);
                        //出现异常
                        if (code != ErrorCode.SUCCESS) {
                            Toast.makeText(MainActivity.this, "语音合成失败,错误码: " + code, Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        answer_text.setText("好像出现了一点问题,待会再试试吧!");
                        //将返回内容读出来
                        int code = mTts.startSpeaking("好像出现了一点问题,待会再试吧!", mTtsListener);
                        //出现异常
                        if (code != ErrorCode.SUCCESS) {
                            Toast.makeText(MainActivity.this, "语音合成失败,错误码: " + code, Toast.LENGTH_SHORT).show();
                        }
                    }
                    e(TAG, "onResult*****returnBean:$$$$$$$" + returnBean.toString());

//                    returnBean =null;

                    //初始化webview的配置
                    wb_result.setWebViewClient(new WebViewClient() {
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            view.loadUrl(url);
                            return true;
                        }
                    });
                    //支持js
                    WebSettings settings = wb_result.getSettings();
                    settings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞

                    wb_result.setDownloadListener(new MyWebViewDownLoadListener());
                }
            } else {
                e(TAG, "onResult" + "识别结果不正确。");
                showTip("识别结果不正确。");
            }
        }

        /**
         * 音量改变时候调用
         * @param volume
         * @param data
         */
        @Override
        public void onVolumeChanged(int volume, byte[] data) {
           // showTip("当前正在说话，音量大小：" + volume);
            Log.d(TAG, data.length + "");
        }

        /**
         * 语音结束时调用
         */
        @Override
        public void onEndOfSpeech() {
            // 此回调表示：检测到了语音的尾端点，已经进入识别过程，不再接受语音输入
          //  showTip("结束说话");
        }

        /**
         * 开始说话时调用
         */
        @Override
        public void onBeginOfSpeech() {
            // 此回调表示：sdk内部录音机已经准备好了，用户可以开始语音输入
          //  showTip("开始说话");
        }

        /**
         * 出现错误
         */

        @Override
        public void onError(SpeechError error) {
            e(TAG, "onError" + error.getPlainDescription(true));
          //  showTip(error.getPlainDescription(true));
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };


    /**
     * 语音合成回调监听。
     */
    public SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
           // showTip("开始播放");
        }

        @Override
        public void onSpeakPaused() {
           // showTip("暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            //showTip("继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;
//            showTip(String.format("缓冲进度为%d%%，播放进度为%d%%",
//                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
            mPercentForPlaying = percent;
//            showTip(String.format("缓冲进度为%d%%，播放进度为%d%%",
//                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
             //   showTip("播放完成");

            } else if (error != null) {
                e(TAG, "onCompleted:" + error.getPlainDescription(true));
               // showTip(error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };

    /**
     * 参数设置
     */
    public void setParam() {
        String lang = mSharedPreferences.getString("understander_language_preference", "mandarin");

        //**************初始化语义理解参数*******************//

        if (lang.equals("en_us")) {
            // 设置语言
            mSpeechUnderstander.setParameter(SpeechConstant.LANGUAGE, "en_us");
        } else {
            // 设置语言
            mSpeechUnderstander.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            // 设置语言区域
            mSpeechUnderstander.setParameter(SpeechConstant.ACCENT, lang);
        }
        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mSpeechUnderstander.setParameter(SpeechConstant.VAD_BOS, mSharedPreferences.getString("understander_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mSpeechUnderstander.setParameter(SpeechConstant.VAD_EOS, mSharedPreferences.getString("understander_vadeos_preference", "1000"));

        // 设置标点符号，默认：1（有标点）
        mSpeechUnderstander.setParameter(SpeechConstant.ASR_PTT, mSharedPreferences.getString("understander_punc_preference", "1"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mSpeechUnderstander.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mSpeechUnderstander.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/sud.wav");


        //**************初始化语音合成参数*******************//

        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        if (mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置在线合成发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicer);
            //设置合成语速
            mTts.setParameter(SpeechConstant.SPEED, mSharedPreferences.getString("speed_preference", "50"));
            //设置合成音调
            mTts.setParameter(SpeechConstant.PITCH, mSharedPreferences.getString("pitch_preference", "50"));
            //设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, mSharedPreferences.getString("volume_preference", "50"));
        } else {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            // 设置本地合成发音人 voicer为空，默认通过语记界面指定发音人。
            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
            /**
             * TODO 本地合成不设置语速、音调、音量，默认使用语记设置
             * 开发者如需自定义参数，请参考在线合成参数设置
             */
        }
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, mSharedPreferences.getString("stream_preference", "3"));
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");

    }

    /**
     * webview的下载监听
     */
    private class MyWebViewDownLoadListener implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
                                    long contentLength) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

    }

    /**
     * toast打印工具类
     *
     * @param str
     */
    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }


    @Override
    protected void onResume() {
        //移动数据统计分析
        FlowerCollector.onResume(MainActivity.this);
        FlowerCollector.onPageStart(TAG);
        super.onResume();
    }

    @Override
    protected void onPause() {
        //移动数据统计分析
        FlowerCollector.onPageEnd(TAG);
        FlowerCollector.onPause(MainActivity.this);
        super.onPause();
    }

    /**
     * onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出时释放连接
        mSpeechUnderstander.cancel();
        mSpeechUnderstander.destroy();
        if (mTextUnderstander.isUnderstanding())
            mTextUnderstander.cancel();
        mTextUnderstander.destroy();
        mTts.stopSpeaking();
        // 退出时释放连接
        mTts.destroy();
    }
}
