package com.scaf.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抛出业务级别异常
 * httpStatus 200
 * @author
 */
public class BusinessException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(BusinessException.class);
    private String errno;
    private String errmsg;
    private Object result;

    public BusinessException(ExceptMsg errorMsg) {
        super(errorMsg.errmsg());
        log.warn("ERROR_LOGIC:[{}]", errorMsg.errmsg());
        this.errno = errorMsg.errno();
        this.errmsg = errorMsg.errmsg();
    }


    public BusinessException(ExceptMsg errorMsg, String errmsg) {
        super(errorMsg.errmsg());
        log.warn("ERROR_LOGIC:[{}]", errmsg);
        this.errno = errorMsg.errno();
        this.errmsg = errmsg;
    }

    public BusinessException(String errno, String msg, Object data) {
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

    public void setErrmsg(final String errmsg) {
        this.errmsg = errmsg;
    }

    public void setResult(final Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BusinessException(errno=" + this.getErrno() + ", msg=" + this.getErrmsg() + ", data=" + this.getResult() + ")";
    }
}
