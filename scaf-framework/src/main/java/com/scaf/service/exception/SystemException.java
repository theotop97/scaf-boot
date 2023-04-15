package com.scaf.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抛出系统级别异常-用于mq重试
 * httpStatus 500
 * @author 01388647
 */
public class SystemException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(SystemException.class);
    private String errno;
    private String errmsg;
    private Object result;

    public SystemException(ExceptMsg errorMsg) {
        super(errorMsg.errmsg());
        log.warn("SYS_LOGIC:[{}]", errorMsg.errmsg());
        this.errno = errorMsg.errno();
        this.errmsg = errorMsg.errmsg();
    }

    public SystemException(ExceptMsg errorMsg, String msg) {
        super(msg);
        this.errno = errorMsg.errno();
        this.errmsg = msg;
    }

    public SystemException(String errno, String msg, Object data) {
        super(msg);
        this.errno = errno;
        this.errmsg = msg;
        this.result = data;
    }

    public String getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public Object getResult() {
        return this.result;
    }

    public void setErrno(final String errno) {
        this.errno = errno;
    }

    public void setMsg(final String msg) {
        this.errmsg = msg;
    }

    public void setResult(final Object data) {
        this.result = data;
    }

    @Override
    public String toString() {
        return "SystemException(errno=" + this.getErrno() + ", msg=" + this.getErrmsg() + ", data=" + this.getResult() + ")";
    }
}

