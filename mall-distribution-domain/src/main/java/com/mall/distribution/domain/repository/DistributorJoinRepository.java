package com.mall.distribution.domain.repository;

import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.model.join.DistributorJoin;

import java.util.List;
import java.util.Optional;

/**
 * 分销商申请仓储接口
 */
public interface DistributorJoinRepository {

    /**
     * 保存分销商申请
     */
    DistributorJoin save(DistributorJoin distributorJoin);

    /**
     * 根据会员ID查找申请
     */
    Optional<DistributorJoin> findByMemberId(Long memberId);

    /**
     * 根据身份证号查找申请
     */
    Optional<DistributorJoin> findByIdCartNumber(String idCartNumber);

    /**
     * 查找所有申请
     */
    List<DistributorJoin> findAll();

    /**
     * 根据状态查找申请
     */
    List<DistributorJoin> findByState(Integer state);

    /**
     * 检查会员是否已申请
     */
    boolean existsByMemberId(Long memberId);

    Optional<DistributorJoin> findById(Long joinId);

    List<DistributorJoin> findByQuery(DistributorJoinQuery query);

    boolean existsPendingByUserId(Long userId);

    /**
     * 检查身份证号是否已申请
     */
    boolean existsByIdCartNumber(String idCartNumber);

    /**
     * 根据会员ID删除申请
     */
    void deleteByMemberId(Long memberId);
}
