package com.mall.distribution.adapter.out.persistence.converter;

import com.mall.distribution.adapter.out.persistence.entity.CommissionCashEntity;

import com.mall.distribution.domain.model.cash.CommissionCash;
import org.springframework.stereotype.Component;

/**
 * 佣金提现转换器
 */
@Component
public class CommissionCashConverter {

    /**
     * 领域对象转实体
     */
    public CommissionCashEntity toEntity(CommissionCash commissionCash) {
        if (commissionCash == null) {
            return null;
        }

        CommissionCashEntity entity = new CommissionCashEntity();
        entity.setCashId(commissionCash.getCashId());
        entity.setDistributorId(commissionCash.getDistributorId());
        entity.setCashAmount(commissionCash.getCashAmount());
        entity.setBankCard(commissionCash.getBankCard());
        entity.setBankName(commissionCash.getBankName());
        entity.setBankBranch(commissionCash.getBankBranch());
        entity.setCashStatus(commissionCash.getCashStatus());
        entity.setAuditTime(commissionCash.getAuditTime());
        entity.setAuditBy(commissionCash.getAuditBy());
        entity.setAuditRemark(commissionCash.getAuditRemark());
        entity.setPayTime(commissionCash.getPayTime());
        entity.setPaymentNo(commissionCash.getPaymentNo());
        entity.setPaidBy(commissionCash.getPaidBy());
        entity.setCreatedAt(commissionCash.getCreatedAt());
        entity.setCreatedBy(commissionCash.getCreatedBy());
        entity.setUpdatedAt(commissionCash.getUpdatedAt());
        entity.setUpdatedBy(commissionCash.getUpdatedBy());

        return entity;
    }

    /**
     * 实体转领域对象
     */
    public CommissionCash toDomain(CommissionCashEntity entity) {
        if (entity == null) {
            return null;
        }

        return new CommissionCash(
            entity.getCashId(),
            entity.getDistributorId(),
            entity.getCashAmount(),
            entity.getBankCard(),
            entity.getBankName(),
            entity.getBankBranch(),
            entity.getCashStatus(),
            entity.getAuditTime(),
            entity.getAuditBy(),
            entity.getAuditRemark(),
            entity.getPayTime(),
            entity.getPaymentNo(),
            entity.getPaidBy(),
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getUpdatedAt(),
            entity.getUpdatedBy()
        );
    }
}
