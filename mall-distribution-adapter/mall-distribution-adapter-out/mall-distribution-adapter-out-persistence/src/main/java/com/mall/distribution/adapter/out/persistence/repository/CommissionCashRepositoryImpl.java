package com.mall.distribution.adapter.out.persistence.repository;

import com.mall.distribution.adapter.out.persistence.converter.CommissionCashConverter;
import com.mall.distribution.adapter.out.persistence.entity.CommissionCashEntity;
import com.mall.distribution.adapter.out.persistence.mapper.CommissionCashMapper;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.domain.commission.CommissionCash;
import com.mall.distribution.domain.commission.CommissionCashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 佣金提现仓储实现
 */
@Repository
@RequiredArgsConstructor
public class CommissionCashRepositoryImpl implements CommissionCashRepository {
    
    private final CommissionCashMapper commissionCashMapper;
    private final CommissionCashConverter commissionCashConverter;
    
    @Override
    public void save(CommissionCash commissionCash) {
        CommissionCashEntity entity = commissionCashConverter.toEntity(commissionCash);
        
        if (entity.getCashId() == null) {
            // 新增
            commissionCashMapper.insert(entity);
            // 设置生成的ID
            commissionCash.setCashId(entity.getCashId());
        } else {
            // 更新
            commissionCashMapper.updateById(entity);
        }
    }
    
    @Override
    public Optional<CommissionCash> findById(Long cashId) {
        CommissionCashEntity entity = commissionCashMapper.selectById(cashId);
        return Optional.ofNullable(commissionCashConverter.toDomain(entity));
    }
    
    @Override
    public List<CommissionCash> findByQuery(CommissionCashQuery query) {
        List<CommissionCashEntity> entities = commissionCashMapper.findByQuery(query);
        return entities.stream()
            .map(commissionCashConverter::toDomain)
            .collect(Collectors.toList());
    }
}