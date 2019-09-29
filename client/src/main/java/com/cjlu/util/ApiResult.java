package com.cjlu.util;

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private String msg;
    private long count;
    private T data;
}
