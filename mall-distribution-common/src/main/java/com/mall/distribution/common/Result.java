package com.mall.distribution.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.distribution.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 统一响应结果封装类
 * 用于封装所有API接口的返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    
    /**
     * HTTP状态码
     */
    private int httpCode;
    
    /**
     * 业务状态码
     */
    private int code;
    
    /**
     * 响应消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 响应时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    /**
     * 请求跟踪ID
     */
    private String traceId;
    
    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return this.code == Resp.SUCCESS.getCode();
    }
    
    /**
     * 判断是否失败
     */
    public boolean isFail() {
        return !isSuccess();
    }
    
    /**
     * 创建成功响应
     */
    public static <T> Result<T> success() {
        return success(null);
    }
    
    /**
     * 创建成功响应（带数据）
     */
    public static <T> Result<T> success(T data) {
        return success(Resp.SUCCESS.getMessage(), data);
    }
    
    /**
     * 创建成功响应（带消息和数据）
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setHttpCode(200);
        result.setCode(Resp.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp(LocalDateTime.now());
        return result;
    }
    
    /**
     * 创建失败响应
     */
    public static <T> Result<T> fail(Resp resp) {
        return fail(resp, null);
    }
    
    /**
     * 创建失败响应（带数据）
     */
    public static <T> Result<T> fail(Resp resp, T data) {
        Result<T> result = new Result<>();
        result.setHttpCode(getHttpCodeFromResp(resp));
        result.setCode(resp.getCode());
        result.setMessage(resp.getMessage());
        result.setData(data);
        result.setTimestamp(LocalDateTime.now());
        return result;
    }
    
    /**
     * 创建失败响应（自定义消息）
     */
    public static <T> Result<T> fail(Resp resp, String message) {
        Result<T> result = new Result<>();
        result.setHttpCode(getHttpCodeFromResp(resp));
        result.setCode(resp.getCode());
        result.setMessage(message);
        result.setTimestamp(LocalDateTime.now());
        return result;
    }
    
    /**
     * 创建失败响应（自定义消息和数据）
     */
    public static <T> Result<T> fail(Resp resp, String message, T data) {
        Result<T> result = new Result<>();
        result.setHttpCode(getHttpCodeFromResp(resp));
        result.setCode(resp.getCode());
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp(LocalDateTime.now());
        return result;
    }
    
    /**
     * 根据业务状态码获取HTTP状态码
     */
    private static int getHttpCodeFromResp(Resp resp) {
        if (resp.getCode() >= 400 && resp.getCode() < 500) {
            return 400;
        } else if (resp.getCode() >= 500) {
            return 500;
        }
        return 200;
    }
}