package com.mall.distribution.adapter.out.persistence.repository;

import com.mall.distribution.adapter.out.persistence.converter.DistributorJoinConverter;
import com.mall.distribution.adapter.out.persistence.entity.DistributorJoinEntity;
import com.mall.distribution.adapter.out.persistence.mapper.DistributorJoinMapper;
import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.distributor.DistributorJoin;
import com.mall.distribution.domain.distributor.DistributorJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 分销商申请仓储实现
 */
@Repository
@RequiredArgsConstructor
public class DistributorJoinRepositoryImpl implements DistributorJoinRepository {
    
    private final DistributorJoinMapper distributorJoinMapper;
    private final DistributorJoinConverter distributorJoinConverter;
    
    @Override
    public void save(DistributorJoin distributorJoin) {
        DistributorJoinEntity entity = distributorJoinConverter.toEntity(distributorJoin);
        
        if (entity.getJoinId() == null) {
            // 新增
            distributorJoinMapper.insert(entity);
            // 设置生成的ID
            distributorJoin.setJoinId(entity.getJoinId());
        } else {
            // 更新
            distributorJoinMapper.updateById(entity);
        }
    }
    
    @Override
    public Optional<DistributorJoin> findById(Long joinId) {
        DistributorJoinEntity entity = distributorJoinMapper.selectById(joinId);
        return Optional.ofNullable(distributorJoinConverter.toDomain(entity));
    }
    
    @Override
    public List<DistributorJoin> findByQuery(DistributorJoinQuery query) {
        List<DistributorJoinEntity> entities = distributorJoinMapper.findByQuery(query);
        return entities.stream()
            .map(distributorJoinConverter::toDomain)
            .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsPendingByUserId(Long userId) {
        return distributorJoinMapper.existsPendingByUserId(userId);
    }
}