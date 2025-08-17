package com.mall.distribution.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 分销服务响应状态码枚举
 * 定义了分销服务相关的所有响应状态码
 */
@Getter
@AllArgsConstructor
public enum Resp {
    
    // 通用状态码 (1000-1099)
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    PARAM_ERROR(400, "参数错误"),
    NOT_FOUND(404, "资源不存在"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    
    // 分销商相关 (3000-3099)
    DISTRIBUTOR_NOT_FOUND(3001, "分销商不存在"),
    DISTRIBUTOR_ALREADY_EXISTS(3002, "分销商已存在"),
    DISTRIBUTOR_ID_CARD_EXISTS(3003, "身份证号已存在"),
    DISTRIBUTOR_PHONE_EXISTS(3004, "手机号已存在"),
    DISTRIBUTOR_EMAIL_EXISTS(3005, "邮箱已存在"),
    DISTRIBUTOR_STATUS_INVALID(3006, "分销商状态无效"),
    DISTRIBUTOR_COMMISSION_INSUFFICIENT(3007, "佣金余额不足"),
    DISTRIBUTOR_BANK_INFO_INVALID(3008, "银行信息无效"),
    DISTRIBUTOR_ID_CARD_INVALID(3009, "身份证信息无效"),
    DISTRIBUTOR_REAL_NAME_EMPTY(3010, "真实姓名不能为空"),
    
    // 分销商申请相关 (3100-3199)
    DISTRIBUTOR_JOIN_NOT_FOUND(3101, "分销商申请不存在"),
    DISTRIBUTOR_JOIN_ALREADY_EXISTS(3102, "分销商申请已存在"),
    DISTRIBUTOR_JOIN_STATUS_INVALID(3103, "申请状态无效"),
    DISTRIBUTOR_JOIN_ALREADY_PROCESSED(3104, "申请已处理"),
    DISTRIBUTOR_JOIN_REJECTED(3105, "申请已被拒绝"),
    DISTRIBUTOR_JOIN_APPROVED(3106, "申请已通过"),
    
    // 佣金提现相关 (3200-3299)
    COMMISSION_CASH_NOT_FOUND(3201, "提现记录不存在"),
    COMMISSION_CASH_AMOUNT_INVALID(3202, "提现金额无效"),
    COMMISSION_CASH_AMOUNT_EXCEEDED(3203, "提现金额超过可用余额"),
    COMMISSION_CASH_STATUS_INVALID(3204, "提现状态无效"),
    COMMISSION_CASH_ALREADY_PROCESSED(3205, "提现已处理"),
    COMMISSION_CASH_MIN_AMOUNT(3206, "提现金额不能低于最小限额"),
    COMMISSION_CASH_DAILY_LIMIT(3207, "超过每日提现限额"),
    
    // 佣金日志相关 (3300-3399)
    COMMISSION_LOG_NOT_FOUND(3301, "佣金日志不存在"),
    COMMISSION_LOG_OPERATION_INVALID(3302, "佣金操作类型无效"),
    
    // 分销商品相关 (3400-3499)
    DISTRIBUTION_GOODS_NOT_FOUND(3401, "分销商品不存在"),
    DISTRIBUTION_GOODS_ALREADY_EXISTS(3402, "分销商品已存在"),
    DISTRIBUTION_GOODS_COMMISSION_INVALID(3403, "商品佣金比例无效"),
    DISTRIBUTION_GOODS_STORE_INVALID(3404, "商品店铺无效"),
    
    // 分销商商品相关 (3500-3599)
    DISTRIBUTOR_GOODS_NOT_FOUND(3501, "分销商商品不存在"),
    DISTRIBUTOR_GOODS_ALREADY_EXISTS(3502, "分销商商品已存在"),
    DISTRIBUTOR_GOODS_FAVORITES_INVALID(3503, "收藏夹无效"),
    
    // 分销商收藏夹相关 (3600-3699)
    DISTRIBUTOR_FAVORITES_NOT_FOUND(3601, "收藏夹不存在"),
    DISTRIBUTOR_FAVORITES_NAME_EXISTS(3602, "收藏夹名称已存在"),
    DISTRIBUTOR_FAVORITES_NAME_EMPTY(3603, "收藏夹名称不能为空"),
    DISTRIBUTOR_FAVORITES_DEFAULT_DELETE(3604, "默认收藏夹不能删除"),
    
    // 分销订单相关 (3700-3799)
    DISTRIBUTION_ORDER_NOT_FOUND(3701, "分销订单不存在"),
    DISTRIBUTION_ORDER_STATUS_INVALID(3702, "分销订单状态无效"),
    DISTRIBUTION_ORDER_COMMISSION_INVALID(3703, "分销订单佣金无效"),
    
    // 分销店铺相关 (3800-3899)
    DISTRIBUTION_STORE_NOT_FOUND(3801, "分销店铺不存在"),
    DISTRIBUTION_STORE_COMMISSION_INVALID(3802, "店铺佣金比例无效"),
    
    // 分销统计相关 (3900-3999)
    DISTRIBUTION_STAT_NOT_FOUND(3901, "分销统计不存在"),
    DISTRIBUTION_STAT_DATE_INVALID(3902, "统计日期无效"),
    DISTRIBUTION_STAT_HOUR_INVALID(3903, "统计小时无效");
    
    private final int code;
    private final String message;
}