package com.scaf.config.result;

import com.scaf.service.exception.ExceptMsg;

public class RestResult {

    private int errNo;
    private String errMessage;
    private Object data;


    public RestResult(String errMessage, Object data) {
        this.errMessage = errMessage;
        this.data = data;
    }

    public RestResult(int errNo, Object data) {
        this.errNo = errNo;
        this.data = data;
    }

    public RestResult(int errNo, String errMessage) {
        this.errNo = errNo;
        this.errMessage = errMessage;
    }

    public RestResult() {
    }

    public RestResult(int errNo, String errMessage, Object data) {
        this.errNo = errNo;
        this.errMessage = errMessage;
        this.data = data;
    }

    public RestResult(ExceptMsg msg) {
        this.errNo = Integer.parseInt(msg.errno());
        this.errMessage = msg.errmsg();
        this.data = null;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "errNo=" + errNo +
                ", errMessage='" + errMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
