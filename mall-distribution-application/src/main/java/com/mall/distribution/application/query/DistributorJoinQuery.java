package com.mall.distribution.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分销商申请查询对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributorJoinQuery {
    
    /**
     * 申请ID
     */
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
     * 审核状态 (0-待审核, 1-审核通过, 2-审核拒绝)
     */
    private Integer auditStatus;
    
    /**
     * 页码
     */
    private Integer pageNum = 1;
    
    /**
     * 页大小
     */
    private Integer pageSize = 10;
}