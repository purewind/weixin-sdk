package com.riversoft.weixin.app.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by king on 2018/4/9.
 */
public class MiniProgramPage implements Serializable {

    private String title;

    @JsonProperty("pagepath")
    private String pagePath;

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public MiniProgramPage title(String title) {
        this.title = title;
        return this;
    }

    public MiniProgramPage thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    public MiniProgramPage pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }
}
