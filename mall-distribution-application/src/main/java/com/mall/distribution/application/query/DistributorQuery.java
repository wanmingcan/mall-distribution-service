package com.mall.distribution.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分销商查询对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributorQuery {
    
    /**
     * 分销商ID
     */
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
     * 状态 (0-禁用, 1-启用)
     */
    private Integer status;
    
    /**
     * 页码
     */
    private Integer pageNum = 1;
    
    /**
     * 页大小
     */
    private Integer pageSize = 10;
}