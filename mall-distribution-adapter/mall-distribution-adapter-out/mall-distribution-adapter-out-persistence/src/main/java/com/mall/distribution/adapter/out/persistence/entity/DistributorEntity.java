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
 * 分销商实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("distributor")
public class DistributorEntity {
    
    /**
     * 分销商ID
     */
    @TableId(type = IdType.AUTO)
    private Long distributorId;
    
    /**
     * 用户ID
     */
    private Long userId;
    
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
     * 佣金余额
     */
    private BigDecimal commissionBalance;
    
    /**
     * 累计佣金
     */
    private BigDecimal totalCommission;
    
    /**
     * 状态 (0-禁用, 1-启用)
     */
    private Integer status;
    
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