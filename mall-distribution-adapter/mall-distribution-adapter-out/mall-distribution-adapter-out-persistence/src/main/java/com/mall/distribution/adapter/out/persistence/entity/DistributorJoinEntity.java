package com.mall.distribution.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 分销商申请实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("distributor_join")
public class DistributorJoinEntity {
    
    /**
     * 申请ID
     */
    @TableId(type = IdType.AUTO)
    private Long joinId;
    
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
     * 审核状态 (0-待审核, 1-审核通过, 2-审核拒绝)
     */
    private Integer auditStatus;
    
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