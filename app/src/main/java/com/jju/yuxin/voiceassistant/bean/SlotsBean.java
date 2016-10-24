package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 1:03.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */


public class SlotsBean {

    /**
     * 内容
     */
    private String content;
    /**
     * 关键字
     */
    private String keywords;

    /**
     *  被查询字段/queryField
     */

    private String queryField;

    /**
     * 交易所/category
     */
    private String category;
    /**
     *  名称/name
     */
    private String name;
    /**
     * 代码/code
     */
    private String code;

    /**
     * 搜索引擎/channel
     */
    private String channel;
    /**
     * 网址/url
     */

    private String url;

    /**
     * 目标语言/target
     */
    private String target;
    /**
     * 所属语言/source
     */
    private String source;
    /**
     * 留言类型/messageType
     */

    private String messageType;
    /**
     * 菜谱名称:dishName
     */

    private String dishName;

    private  LocationBean location;
    /**
     * type : LOC_POI
     * city : CURRENT_CITY
     * poi : 北京南
     */

    private EndLocBean endLoc;
    /**
     * cityAddr : 合肥
     * city : 合肥市
     * type : LOC_BASIC
     */


    private StartLocBean startLoc;

    private StartDateBean startDate;

    private StartTimeBean startTime;


    private DateTimeBean datetime;



    /**

     * distance : 三公里
     */

    private String distance;
    /**
     * artist : 张信哲
     * song : 爱如潮水
     */

    private String artist;
    private String song;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getQueryField() {
        return queryField;
    }

    public void setQueryField(String queryField) {
        this.queryField = queryField;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public EndLocBean getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(EndLocBean endLoc) {
        this.endLoc = endLoc;
    }

    public StartLocBean getStartLoc() {
        return startLoc;
    }

    public void setStartLoc(StartLocBean startLoc) {
        this.startLoc = startLoc;
    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


    public StartDateBean getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDateBean startDate) {
        this.startDate = startDate;
    }

    public StartTimeBean getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTimeBean startTime) {
        this.startTime = startTime;
    }

    public DateTimeBean getDatetime() {
        return datetime;
    }

    public void setDatetime(DateTimeBean datetime) {
        this.datetime = datetime;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "SlotsBean{" +
                "artist='" + artist + '\'' +
                ", content='" + content + '\'' +
                ", keywords='" + keywords + '\'' +
                ", queryField='" + queryField + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", channel='" + channel + '\'' +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                ", source='" + source + '\'' +
                ", messageType='" + messageType + '\'' +
                ", dishName='" + dishName + '\'' +
                ", location=" + location +
                ", endLoc=" + endLoc +
                ", startLoc=" + startLoc +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", datetime=" + datetime +
                ", distance='" + distance + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}