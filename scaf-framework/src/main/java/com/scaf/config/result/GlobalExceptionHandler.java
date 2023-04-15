package com.scaf.config.result;

import com.fasterxml.jackson.core.JsonParseException;
import com.scaf.service.exception.BusinessException;
import com.scaf.service.exception.ConstantException;
import com.scaf.service.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Autowired
    SourceHandler sourceHandler;

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        log.error("ERROR_SYS:", e);
        RestResult result = new RestResult("-1", "系统繁忙，请稍后再试");
        result.setData("请求异常");
        return result;
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object noHandleExceptionHandler(NoHandlerFoundException e) {
        log.warn("NOT_FOUND_HANDLER: ", e);
        return new RestResult( "404", "not found");
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Object notSupportExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.warn("METHOD_NOT_SUPPORTED: ", e);
        return new RestResult( "405", "不支持当前请求方法");
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Object notSupportedMediaType(HttpMediaTypeNotSupportedException e) {
        log.warn("MEDIA_TYPE_NOT_SUPPORTED: ", e);
        return new RestResult( "415", "不支持当前媒体类型");
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Object numberExceptionHandler(MethodArgumentTypeMismatchException ex) {
        return new RestResult("-2",  "参数类型异常");
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Object missParamExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("MISS_PARAM: ", ex);
        String parameterName = ex.getParameterName();
        return new RestResult("-2", "缺少参数: " + parameterName);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({JsonParseException.class})
    public Object jsonExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        log.warn("JSON_PARSE_ERROR: ", e);
        return new RestResult( "-2", "json解析异常");

    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ValidationException.class})
    public Object validationExceptionHandler(ValidationException exception) {
        log.error("VALIDATION_ERROR: ", exception);
        return new RestResult(EnumMsg.ParamError);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SystemException.class})
    public Object systemExceptionHandler(HttpServletRequest request, SystemException exception, HttpServletResponse response) {
        log.warn("sys_logic: ", exception);
        String message = (String)this.sourceHandler.resource(request).property(exception.getErrno()).orElse(exception.getErrmsg() != null ? exception.getErrmsg() : "");
        if (message.contains("%s") && null != exception.getResult()) {
            if (exception.getResult().getClass().isArray()) {
                message = String.format(message, exception.getResult());
            }

            if (exception.getResult() instanceof List) {
                message = String.format(message, ((List)exception.getResult()).toArray());
            }
        }

        return new RestResult(Integer.parseInt(exception.getErrno()), message, exception.getResult());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BusinessException.class})
    public Object businessExceptionHandler(HttpServletRequest request, BusinessException exception) {
        log.warn("business_error: ", exception);
        String message = this.sourceHandler.resource(request).property(exception.getErrno()).orElse(exception.getErrmsg() != null ? exception.getErrmsg() : "");
        if (message.contains("%s") && null != exception.getResult()) {
            if (exception.getResult().getClass().isArray()) {
                message = String.format(message, exception.getResult());
            }

            if (exception.getResult() instanceof List) {
                message = String.format(message, ((List)exception.getResult()).toArray());
            }
        }

        return new RestResult(Integer.parseInt(exception.getErrno()), message, exception.getResult());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({IllegalArgumentException.class})
    public Object illegalArgumentExceptionHandler(HttpServletRequest request, IllegalArgumentException exception) {
        log.warn("IllegalArgumentException: ", exception);
        return new RestResult(ConstantException.PARAM_ERROR.errno(), exception.getMessage());
    }

}

