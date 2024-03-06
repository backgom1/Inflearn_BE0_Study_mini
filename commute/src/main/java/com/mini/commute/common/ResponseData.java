package com.mini.commute.common;

import lombok.Getter;

@Getter
public class ResponseData {
    private int code;
    private Object data;

    public ResponseData(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}
