package com.riversoft.weixin.mp.template;

import lombok.Builder;

/**
 * Created by exizhai on 12/16/2015.
 */
@Builder
@lombok.Data
public class Data {

    private String value;
    private String color;

    public Data() {
    }

    public Data(String value) {
        this.value = value;
    }
    public Data(String value, String color) {
        this.value = value;
        this.color = color;
    }
}

