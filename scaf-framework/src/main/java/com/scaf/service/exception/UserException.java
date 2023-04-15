package com.scaf.service.exception;

public class UserException {

    public static BusinessException notFound() {
        return ExceptionUtils.businessException(Error.NOT_FOUND);
    }

    enum Error implements ExceptMsg {
        NOT_FOUND("70001", "未查询到用户"),
        ;

        private String code;
        private String msg;

        Error(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String errno() {
            return code;
        }

        @Override
        public String errmsg() {
            return msg;
        }
    }
}
