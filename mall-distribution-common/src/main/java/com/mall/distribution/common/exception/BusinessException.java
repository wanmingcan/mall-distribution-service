package com.mall.distribution.common.exception;

import com.mall.distribution.common.enums.Resp;
import lombok.Getter;

/**
 * 业务异常类
 * 用于处理分销服务的业务逻辑异常
 */
@Getter
public class BusinessException extends RuntimeException {
    
    private final Resp resp;
    
    public BusinessException(Resp resp) {
        super(resp.getMessage());
        this.resp = resp;
    }
    
    public BusinessException(Resp resp, String message) {
        super(message);
        this.resp = resp;
    }
    
    public BusinessException(Resp resp, Throwable cause) {
        super(resp.getMessage(), cause);
        this.resp = resp;
    }
    
    public BusinessException(Resp resp, String message, Throwable cause) {
        super(message, cause);
        this.resp = resp;
    }
    
    public int getCode() {
        return resp.getCode();
    }
    
    public String getMessage() {
        return super.getMessage();
    }
}