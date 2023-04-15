package com.scaf.service.exception;

/**
 * 所有业务异常
 * @author 01388647
 */
public enum ConstantException implements ExceptMsg {
    /*
     *路线
     */
    PARAM_ERROR("10001", "参数错误"),
    BIZ_ERROR("10002", "正常业务异常"),
    AB_BIZ_ERROR("10003", "非正常业务异常"),

    /*
     *权限
     */
    AUTH_ERROR_CITY("20001", "没有城市权限"),
    AUTH_ERROR_PROJECT("20001", "没有项目权限"),


    /*
     *mq
     */
    MQ_ROUTE_REG_ERROR("60012", "路由注册mq参数错误"),
    MQ_SEND_ERROR("60013", "mq发送失败"),

    /*
     * 结算
     */
    RPC_ERROR("60014", "请求服务fail"),

    TRANSPOTOR_RPC_ERROR("60015", "请求transpotor fail"),
    OHS_RPC_ERROR("60016", "请求ohs fail"),
    ARMS_RPC_ERROR("60018", "请求arms异常"),
    PASS_RPC_ERROR("60019", "请求pass异常"),

    OHS_BIZ_ERROR("60017", "请求ohs业务异常"),

    /**
     * 弃用
     */
    DEPRECATED_ERROR("60016", "当前页面内容有更新，请刷新页面后重试"),

    IS_CRIME("60017", "司机有犯罪记录"),
    ;

    private String errno;
    private String errmsg;

    ConstantException(String code, String msg) {
        this.errno = code;
        this.errmsg = msg;
    }

    @Override
    public String errno() {
        return errno;
    }

    @Override
    public String errmsg() {
        return errmsg;
    }

}
