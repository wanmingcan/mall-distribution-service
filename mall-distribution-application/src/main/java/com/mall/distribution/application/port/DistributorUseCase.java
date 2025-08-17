package com.mall.distribution.application.port;

import com.mall.distribution.application.command.CreateDistributorCommand;
import com.mall.distribution.application.command.UpdateDistributorCommand;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.distributor.Distributor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 分销商用例接口
 */
public interface DistributorUseCase {
    
    /**
     * 创建分销商
     */
    Long createDistributor(CreateDistributorCommand command);
    
    /**
     * 更新分销商
     */
    void updateDistributor(UpdateDistributorCommand command);
    
    /**
     * 根据ID查找分销商
     */
    Distributor findById(Long distributorId);
    
    /**
     * 根据用户ID查找分销商
     */
    Distributor findByUserId(Long userId);
    
    /**
     * 查询分销商列表
     */
    List<Distributor> findDistributors(DistributorQuery query);
    
    /**
     * 启用分销商
     */
    void enableDistributor(Long distributorId, String updatedBy);
    
    /**
     * 禁用分销商
     */
    void disableDistributor(Long distributorId, String updatedBy);
    
    /**
     * 更新佣金余额
     */
    void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy);
    
    /**
     * 更新累计佣金
     */
    void updateTotalCommission(Long distributorId, BigDecimal amount, String updatedBy);
    
    /**
     * 检查用户是否已是分销商
     */
    boolean existsByUserId(Long userId);
    
    /**
     * 检查手机号是否已存在
     */
    boolean existsByPhone(String phone);
    
    /**
     * 检查身份证号是否已存在
     */
    boolean existsByIdCard(String idCard);
}