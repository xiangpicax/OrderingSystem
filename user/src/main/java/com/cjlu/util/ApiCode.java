package com.cjlu.util;

public enum ApiCode {
    SUCCESS(0, "操作成功"),
    FAIL(-1,"失败");
    private final int code;
    private final String msg;
    ApiCode(int code,String msg){
       this.code = code;
       this.msg = msg;
    }
    public int getCode(){return this.code;}
    public String getMsg(){return this.msg;}
}
