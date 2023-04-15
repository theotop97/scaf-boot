package com.scaf.service.exception;



public class ExceptionUtils {

    public static BusinessException businessException(ExceptMsg exceptMsg) {
        return new BusinessException(exceptMsg);
    }

    public static SystemException systemException(ExceptMsg exceptMsg) {
        return new SystemException(exceptMsg);
    }

    public static BusinessException businessException(String code, String msg) {
        return new BusinessException(code, msg, null);
    }

    public static BusinessException businessException(String code, String msg, Object data) {
        return new BusinessException(code, msg, data);
    }

}
