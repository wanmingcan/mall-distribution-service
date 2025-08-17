package com.mall.distribution.domain.repository;

import com.mall.distribution.domain.model.distributor.Distributor;
import com.mall.distribution.domain.model.distributor.DistributorId;

import java.util.List;
import java.util.Optional;

/**
 * 分销商仓储接口
 */
public interface DistributorRepository {
    
    /**
     * 保存分销商
     */
    Distributor save(Distributor distributor);
    
    /**
     * 根据ID查找分销商
     */
    Optional<Distributor> findById(DistributorId distributorId);
    
    /**
     * 根据会员ID查找分销商
     */
    Optional<Distributor> findByMemberId(Integer memberId);
    
    /**
     * 根据身份证号查找分销商
     */
    Optional<Distributor> findByIdCartNumber(String idCartNumber);
    
    /**
     * 根据手机号查找分销商
     */
    Optional<Distributor> findByBindPhone(String bindPhone);
    
    /**
     * 根据邮箱查找分销商
     */
    Optional<Distributor> findByBindEmail(String bindEmail);
    
    /**
     * 查找所有分销商
     */
    List<Distributor> findAll();
    
    /**
     * 根据状态查找分销商
     */
    List<Distributor> findByState(Integer state);
    
    /**
     * 检查身份证号是否存在
     */
    boolean existsByIdCartNumber(String idCartNumber);
    
    /**
     * 检查手机号是否存在
     */
    boolean existsByBindPhone(String bindPhone);
    
    /**
     * 检查邮箱是否存在
     */
    boolean existsByBindEmail(String bindEmail);
    
    /**
     * 检查会员ID是否存在
     */
    boolean existsByMemberId(Integer memberId);
    
    /**
     * 根据ID删除分销商
     */
    void deleteById(DistributorId distributorId);
}