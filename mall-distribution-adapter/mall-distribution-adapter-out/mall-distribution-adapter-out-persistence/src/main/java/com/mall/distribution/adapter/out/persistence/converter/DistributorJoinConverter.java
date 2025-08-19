package com.mall.distribution.adapter.out.persistence.converter;

import com.mall.distribution.adapter.out.persistence.entity.DistributorJoinEntity;

import com.mall.distribution.domain.model.join.DistributorJoin;
import org.springframework.stereotype.Component;

/**
 * 分销商申请转换器
 */
@Component
public class DistributorJoinConverter {

    /**
     * 领域对象转实体
     */
    public DistributorJoinEntity toEntity(DistributorJoin distributorJoin) {
        if (distributorJoin == null) {
            return null;
        }

        DistributorJoinEntity entity = new DistributorJoinEntity();
        entity.setJoinId(distributorJoin.getJoinId());
        entity.setUserId(distributorJoin.getUserId());
        entity.setApplicantName(distributorJoin.getApplicantName());
        entity.setPhone(distributorJoin.getPhone());
        entity.setIdCard(distributorJoin.getIdCard());
        entity.setIdCardFront(distributorJoin.getIdCardFront());
        entity.setIdCardBack(distributorJoin.getIdCardBack());
        entity.setBankCard(distributorJoin.getBankCard());
        entity.setBankName(distributorJoin.getBankName());
        entity.setBankBranch(distributorJoin.getBankBranch());
        entity.setReason(distributorJoin.getReason());
        entity.setAuditStatus(distributorJoin.getAuditStatus());
        entity.setAuditTime(distributorJoin.getAuditTime());
        entity.setAuditBy(distributorJoin.getAuditBy());
        entity.setAuditRemark(distributorJoin.getAuditRemark());
        entity.setCreatedAt(distributorJoin.getCreatedAt());
        entity.setCreatedBy(distributorJoin.getCreatedBy());
        entity.setUpdatedAt(distributorJoin.getUpdatedAt());
        entity.setUpdatedBy(distributorJoin.getUpdatedBy());

        return entity;
    }

    /**
     * 实体转领域对象
     */
    public DistributorJoin toDomain(DistributorJoinEntity entity) {
        if (entity == null) {
            return null;
        }

        return new DistributorJoin(
            entity.getJoinId(),
            entity.getUserId(),
            entity.getApplicantName(),
            entity.getPhone(),
            entity.getIdCard(),
            entity.getIdCardFront(),
            entity.getIdCardBack(),
            entity.getBankCard(),
            entity.getBankName(),
            entity.getBankBranch(),
            entity.getReason(),
            entity.getAuditStatus(),
            entity.getAuditTime(),
            entity.getAuditBy(),
            entity.getAuditRemark(),
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getUpdatedAt(),
            entity.getUpdatedBy()
        );
    }
}
