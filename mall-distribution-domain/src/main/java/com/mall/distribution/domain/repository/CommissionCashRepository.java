package com.mall.distribution.domain.repository;

import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.model.cash.CommissionCash;

import java.util.List;
import java.util.Optional;

/**
 * 佣金提现仓储接口
 */
public interface CommissionCashRepository {

    /**
     * 保存佣金提现
     */
    CommissionCash save(CommissionCash commissionCash);

    /**
     * 根据ID查找提现记录
     */
    Optional<CommissionCash> findById(Long cashId);

    /**
     * 根据提现单号查找
     */
    Optional<CommissionCash> findByCashSn(String cashSn);

    /**
     * 根据分销商ID查找提现记录
     */
    List<CommissionCash> findByDistributorId(Integer distributorId);

    /**
     * 根据会员ID查找提现记录
     */
    List<CommissionCash> findByMemberId(Integer memberId);

    /**
     * 根据状态查找提现记录
     */
    List<CommissionCash> findByState(Integer state);

    /**
     * 查找所有提现记录
     */
    List<CommissionCash> findAll();

    /**
     * 检查提现单号是否存在
     */
    boolean existsByCashSn(String cashSn);

    /**
     * 根据ID删除提现记录
     */
    void deleteById(Long cashId);

    List<CommissionCash> findByQuery(CommissionCashQuery query);

}
