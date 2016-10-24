package com.jju.yuxin.voiceassistant.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.util.ContactManager;
import com.iflytek.cloud.util.ContactManager.ContactListener;
import com.jju.yuxin.voiceassistant.R;

import static android.util.Log.e;

public class HelpActivity extends Activity {

    private static final String TAG =HelpActivity.class.getSimpleName() ;
    private Button tv_upload_contacts;
    private Toast mToast;
    //语音听写对象
    private SpeechRecognizer mIat;
    int ret = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_help);
        TextClickListener listener = new TextClickListener();

        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
        mIat = SpeechRecognizer.createRecognizer(HelpActivity.this, mInitListener);

        mToast = Toast.makeText(HelpActivity.this, "", Toast.LENGTH_SHORT);
        tv_upload_contacts = (Button) findViewById(R.id.tv_upload_contacts);
        tv_upload_contacts.setOnClickListener(listener);
    }

    private class TextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_upload_contacts:
                    showTip(getString(R.string.text_upload_contacts));
                    ContactManager mgr = ContactManager.createManager(HelpActivity.this,
                            mContactListener);
                    mgr.asyncQueryAllContactsName();

                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                e(TAG, "onInit" + "初始化失败，错误码：" + code);
                showTip("初始化失败");
            }
        }
    };

    private ContactListener mContactListener = new ContactListener() {

        @Override
        public void onContactQueryFinish(final String contactInfos, boolean changeFlag) {
            // 注：实际应用中除第一次上传之外，之后应该通过changeFlag判断是否需要上传，否则会造成不必要的流量.
            // 每当联系人发生变化，该接口都将会被回调，可通过ContactManager.destroy()销毁对象，解除回调。
            // if(changeFlag) {
            // 指定引擎类型

            mIat.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            mIat.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
            ret = mIat.updateLexicon("contact", contactInfos, mLexiconListener);
            if (ret != ErrorCode.SUCCESS) {
                showTip("上传联系人失败!");
                e(TAG, "onContactQueryFinish" + "上传联系人失败：" + ret);
            }
        }
    };

    /**
     * 上传联系人/词表监听器。
     */
    private LexiconListener mLexiconListener = new LexiconListener() {

        @Override
        public void onLexiconUpdated(String lexiconId, SpeechError error) {
            if (error != null) {
                e(TAG, "onLexiconUpdated" + error.toString());
                showTip("上传联系人中出现一点错误!");
            } else {
                showTip(getString(R.string.text_upload_success));
            }
        }
    };

    /**
     * toast打印工具类
     *
     * @param str
     */
    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }
}
