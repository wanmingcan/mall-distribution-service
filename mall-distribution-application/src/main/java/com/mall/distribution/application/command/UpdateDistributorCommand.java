package com.mall.distribution.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新分销商命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDistributorCommand {
    
    /**
     * 分销商ID
     */
    private Long distributorId;
    
    /**
     * 分销商名称
     */
    private String distributorName;
    
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
     * 更新人
     */
    private String updatedBy;
}