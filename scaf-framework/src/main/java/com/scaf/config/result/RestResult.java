package com.scaf.config.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scaf.service.exception.ExceptMsg;

public class RestResult {

    @JsonProperty("err_no")
    private int errNo;
    @JsonProperty("err_message")
    private String errMessage;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("log_id")
    private String logId;


    public RestResult(String errMessage, Object data, Long timestamp) {
        this.errMessage = errMessage;
        this.data = data;
        this.timestamp = timestamp;
    }

    public RestResult(int errNo, Object data, Long timestamp) {
        this.errNo = errNo;
        this.data = data;
        this.timestamp = timestamp;
    }

    public RestResult(int errNo, String errMessage, Long timestamp) {
        this.errNo = errNo;
        this.errMessage = errMessage;
        this.timestamp = timestamp;
    }

    public RestResult() {
    }

    public RestResult(int errNo, String errMessage, Object data, Long timestamp) {
        this.errNo = errNo;
        this.errMessage = errMessage;
        this.data = data;
        this.timestamp = timestamp;
    }

    public RestResult(ExceptMsg msg, Long timestamp) {
        this.errNo = Integer.parseInt(msg.errno());
        this.errMessage = msg.errmsg();
        this.data = null;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "errNo=" + errNo +
                ", errMessage='" + errMessage + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                ", logId='" + logId + '\'' +
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = timestamp;
    }

    public void setLogId (String logId) {
        this.logId = logId;
    }

    public String getLogId() {
        return logId;
    }
}
