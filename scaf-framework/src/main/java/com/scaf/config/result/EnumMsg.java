package com.scaf.config.result;


import com.scaf.service.exception.ExceptMsg;

public enum EnumMsg implements ExceptMsg {
    ParamError("-2", "参数错误"),
    ParamTypeError("-2", "参数类型错误");

    private String code;
    private String msg;

    private EnumMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String errno() {
        return this.code;
    }

    @Override
    public String errmsg() {
        return this.msg;
    }
}