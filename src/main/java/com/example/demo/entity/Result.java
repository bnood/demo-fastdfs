package com.example.demo.entity;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = -7284167079213189980L;
    private int code;
    private String msg;
    private T t;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return this.t;
    }

    public Result setT(T t) {
        this.t = t;
        return this;
    }

    public static Result ok(String msg) {
        return new Result(0, msg, (Object)null);
    }

    public static Result ok() {
        return ok("ok");
    }

    public static Result fail(String msg) {
        return new Result(400, msg, (Object)null);
    }

    public static Result fail() {
        return fail("fail");
    }

    public static Result empty(String msg) {
        return new Result(300, msg, (Object)null);
    }

    public static Result empty() {
        return empty("未找到相关数据");
    }

    public boolean isOk() {
        return 0 == this.code;
    }

    public boolean isEmpty() {
        return 300 == this.code;
    }

    public static final int CODE_OK = 0;
    public static final int CODE_FAIL = 400;
    public static final int CODE_EMPTY = 300;
    public static final String CODE_OK_MSG = "ok";
    public static final String CODE_FAIL_MSG = "fail";
    public static final String CODE_EMPTY_MSG = "未找到相关数据";
}
