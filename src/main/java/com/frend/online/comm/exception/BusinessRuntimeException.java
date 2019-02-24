package com.frend.online.comm.exception;

import com.frend.online.comm.bean.ResponseCode;

public class BusinessRuntimeException extends  RuntimeException {

    private int resultCode;

    private String errorMsg;

    private ResponseCode responseCode;

    public BusinessRuntimeException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.resultCode = responseCode.getCode();
        this.errorMsg = responseCode.getMsg();
        this.responseCode = responseCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
