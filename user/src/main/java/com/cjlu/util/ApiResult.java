package com.cjlu.util;

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private String msg;
    private long count;
    private T data;

public ApiResult<T> success(T data){
    this.setCode(ApiCode.SUCCESS.getCode());
    this.setMsg(ApiCode.SUCCESS.getMsg());
    this.setData(data);
    return this;
}
public  ApiResult fail(){
    this.setCode(ApiCode.FAIL.getCode());
    this.setMsg(ApiCode.FAIL.getMsg());
    return this;
}

}
