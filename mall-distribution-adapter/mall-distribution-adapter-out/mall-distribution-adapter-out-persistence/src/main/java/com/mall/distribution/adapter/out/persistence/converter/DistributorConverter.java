package com.mall.distribution.adapter.out.persistence.converter;

import com.mall.distribution.adapter.out.persistence.entity.DistributorEntity;
import com.mall.distribution.domain.distributor.Distributor;
import com.mall.distribution.domain.distributor.DistributorId;
import org.springframework.stereotype.Component;

/**
 * 分销商转换器
 */
@Component
public class DistributorConverter {
    
    /**
     * 领域对象转实体
     */
    public DistributorEntity toEntity(Distributor distributor) {
        if (distributor == null) {
            return null;
        }
        
        DistributorEntity entity = new DistributorEntity();
        entity.setDistributorId(distributor.getDistributorId() != null ? distributor.getDistributorId().getValue() : null);
        entity.setUserId(distributor.getUserId());
        entity.setDistributorName(distributor.getDistributorName());
        entity.setPhone(distributor.getPhone());
        entity.setIdCard(distributor.getIdCard());
        entity.setIdCardFront(distributor.getIdCardFront());
        entity.setIdCardBack(distributor.getIdCardBack());
        entity.setBankCard(distributor.getBankCard());
        entity.setBankName(distributor.getBankName());
        entity.setBankBranch(distributor.getBankBranch());
        entity.setCommissionBalance(distributor.getCommissionBalance());
        entity.setTotalCommission(distributor.getTotalCommission());
        entity.setStatus(distributor.getStatus());
        entity.setCreatedAt(distributor.getCreatedAt());
        entity.setCreatedBy(distributor.getCreatedBy());
        entity.setUpdatedAt(distributor.getUpdatedAt());
        entity.setUpdatedBy(distributor.getUpdatedBy());
        
        return entity;
    }
    
    /**
     * 实体转领域对象
     */
    public Distributor toDomain(DistributorEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Distributor(
            new DistributorId(entity.getDistributorId()),
            entity.getUserId(),
            entity.getDistributorName(),
            entity.getPhone(),
            entity.getIdCard(),
            entity.getIdCardFront(),
            entity.getIdCardBack(),
            entity.getBankCard(),
            entity.getBankName(),
            entity.getBankBranch(),
            entity.getCommissionBalance(),
            entity.getTotalCommission(),
            entity.getStatus(),
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getUpdatedAt(),
            entity.getUpdatedBy()
        );
    }
}