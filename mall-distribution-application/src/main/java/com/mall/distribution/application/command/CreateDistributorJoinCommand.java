package com.mall.distribution.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建分销商申请命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDistributorJoinCommand {
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 申请人姓名
     */
    private String applicantName;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 身份证正面照
     */
    private String idCardFront;
    
    /**
     * 身份证反面照
     */
    private String idCardBack;
    
    /**
     * 银行卡号
     */
    private String bankCard;
    
    /**
     * 银行名称
     */
    private String bankName;
    
    /**
     * 开户行
     */
    private String bankBranch;
    
    /**
     * 申请理由
     */
    private String reason;
    
    /**
     * 创建人
     */
    private String createdBy;
}