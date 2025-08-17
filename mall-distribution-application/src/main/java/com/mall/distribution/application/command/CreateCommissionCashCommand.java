package com.mall.distribution.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 创建佣金提现命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommissionCashCommand {
    
    /**
     * 分销商ID
     */
    private Long distributorId;
    
    /**
     * 提现金额
     */
    private BigDecimal cashAmount;
    
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
     * 创建人
     */
    private String createdBy;
}