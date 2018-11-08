package com.riversoft.weixin.app.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by king on 2018/4/9.
 */
public class Link implements Serializable {

    private String title;

    private String description;

    @JsonProperty("thumb_url")
    private String thumbUrl;

    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Link title(String title) {
        this.title = title;
        return this;
    }

    public Link url(String url) {
        this.url = url;
        return this;
    }

    public Link description(String description) {
        this.description = description;
        return this;
    }

    public Link thumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }
}
