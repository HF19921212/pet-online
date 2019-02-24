package com.frend.online.comm.exception;

import com.frend.online.comm.bean.ResponseCode;
import com.frend.online.comm.bean.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionResolver{

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e) {
        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return ResponseResult.e(ResponseCode.FAIL);
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public ResponseResult handleOpdRuntimeException(BusinessRuntimeException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getErrorMsg());
        return ResponseResult.e(e.getResponseCode());
    }

}
