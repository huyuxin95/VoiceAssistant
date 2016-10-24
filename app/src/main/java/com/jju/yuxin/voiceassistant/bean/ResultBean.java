package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:03.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class ResultBean {

    private String singer;

    private String sourceName;
    /**
     * 名称/name
     */
    private String name;
    /**
     * 下载链接
     */
    private String downloadUrl;

    /**
     * 分类/category
     */
    private String category;
    /**
     * 价格/price
     */
    private String price;
    /**
     * 链接/url
     */
    private String url;
    /**
     * 图片链接/imgUrl
     */
    private String imgUrl;
    /**
     * 组成/composition
     */
    private String composition;
    /**
     * accessory : 姜片:适量;老抽:适量; 蒜瓣:适量;八角:适量;花椒:适量;冰糖:适量; 黄酒:适量;盐:适量
     * source : 豆果网
     * ingredient : 五花肉:适量
     * cuisine :
     */

    /**
     * 辅助材料/accessory
     */
    private String accessory;
    /**
     * 信息来源/source
     */
    private String source;
    /**
     * 主要材料/ingredient
     */
    private String ingredient;
    /**
     * 菜系/cuisine
     */
    private String cuisine;
    /**
     * airQuality : 良
     * date : 2016-10-21
     * lastUpdateTime : 2016-10-21 14:20:08
     * dateLong : 1476979200
     * pm25 : 54
     * city : 北京
     * humidity : 91%
     * windLevel : 0
     * weather : 小雨
     * tempRange : 11℃~13℃
     * wind : 无持续风向微风
     */

    private String airQuality;
    private String date;
    private String lastUpdateTime;
    private int dateLong;
    private String pm25;
    private String city;
    private String humidity;
    private int windLevel;
    private String weather;
    private String tempRange;
    private String wind;
    /**
     * aqi : 23
     * publishDateTime : 2016-10-21 13:00:00
     * subArea : 蜀山区
     * publishDateTimeLong : 1477026000
     * positionName : 全局监测
     * quality : 优
     * area : 合肥
     */

    private int aqi;
    private String publishDateTime;
    private String subArea;
    private int publishDateTimeLong;
    private String positionName;
    private String quality;
    private String area;

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(String airQuality) {
        this.airQuality = airQuality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getDateLong() {
        return dateLong;
    }

    public void setDateLong(int dateLong) {
        this.dateLong = dateLong;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public int getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(int windLevel) {
        this.windLevel = windLevel;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTempRange() {
        return tempRange;
    }

    public void setTempRange(String tempRange) {
        this.tempRange = tempRange;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(String publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public int getPublishDateTimeLong() {
        return publishDateTimeLong;
    }

    public void setPublishDateTimeLong(int publishDateTimeLong) {
        this.publishDateTimeLong = publishDateTimeLong;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "accessory='" + accessory + '\'' +
                ", singer='" + singer + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", name='" + name + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", composition='" + composition + '\'' +
                ", source='" + source + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", airQuality='" + airQuality + '\'' +
                ", date='" + date + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", dateLong=" + dateLong +
                ", pm25='" + pm25 + '\'' +
                ", city='" + city + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windLevel=" + windLevel +
                ", weather='" + weather + '\'' +
                ", tempRange='" + tempRange + '\'' +
                ", wind='" + wind + '\'' +
                ", aqi=" + aqi +
                ", publishDateTime='" + publishDateTime + '\'' +
                ", subArea='" + subArea + '\'' +
                ", publishDateTimeLong=" + publishDateTimeLong +
                ", positionName='" + positionName + '\'' +
                ", quality='" + quality + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
