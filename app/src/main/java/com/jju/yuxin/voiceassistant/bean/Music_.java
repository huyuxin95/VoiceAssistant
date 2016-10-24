package com.jju.yuxin.voiceassistant.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.musicplayer.domain
 * Created by yuxin.
 * Created time 2016/10/16 0016 上午 9:18.
 * Version   1.0;
 * Describe : Music_的bean类 实现Parcelable序列化
 * History:
 * ==============================================================================
 */

public class Music_ implements Parcelable {

    private int id;  //id
    private String name;  //歌曲名称
    private String author;  //歌手
    private String path;  //歌曲路径


    public Music_() {
    }

    public Music_(int id, String name, String author, String uri) {
        this.id = id;
        this.name = name;
        this.path = uri;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.author);
        dest.writeString(this.path);
    }

    protected Music_(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.author = in.readString();
        this.path = in.readString();
    }

    public static final Creator<Music_> CREATOR = new Creator<Music_>() {
        @Override
        public Music_ createFromParcel(Parcel source) {
            return new Music_(source);
        }

        @Override
        public Music_[] newArray(int size) {
            return new Music_[size];
        }
    };

    @Override
    public String toString() {
        return "Music_{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
