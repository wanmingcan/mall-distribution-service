package com.mall.distribution.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 佣金提现实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("distribution_commission_cash")
public class CommissionCashEntity {
    
    /**
     * 提现ID
     */
    @TableId(type = IdType.AUTO)
    private Long cashId;
    
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
     * 提现状态 (0-待审核, 1-审核通过, 2-审核拒绝, 3-已支付)
     */
    private Integer cashStatus;
    
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
    
    /**
     * 审核人
     */
    private String auditBy;
    
    /**
     * 审核备注
     */
    private String auditRemark;
    
    /**
     * 支付时间
     */
    private LocalDateTime payTime;
    
    /**
     * 支付单号
     */
    private String paymentNo;
    
    /**
     * 支付人
     */
    private String paidBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    
    /**
     * 创建人
     */
    private String createdBy;
    
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    
    /**
     * 更新人
     */
    private String updatedBy;
}