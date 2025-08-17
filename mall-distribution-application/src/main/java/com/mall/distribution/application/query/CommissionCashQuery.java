package com.mall.distribution.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 佣金提现查询对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommissionCashQuery {
    
    /**
     * 提现ID
     */
    private Long cashId;
    
    /**
     * 分销商ID
     */
    private Long distributorId;
    
    /**
     * 提现状态 (0-待审核, 1-审核通过, 2-审核拒绝, 3-已支付)
     */
    private Integer cashStatus;
    
    /**
     * 页码
     */
    private Integer pageNum = 1;
    
    /**
     * 页大小
     */
    private Integer pageSize = 10;
}