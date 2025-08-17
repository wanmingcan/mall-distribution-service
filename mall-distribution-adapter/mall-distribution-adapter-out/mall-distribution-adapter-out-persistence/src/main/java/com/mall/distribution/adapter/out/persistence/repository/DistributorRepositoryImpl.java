package com.mall.distribution.adapter.out.persistence.repository;

import com.mall.distribution.adapter.out.persistence.converter.DistributorConverter;
import com.mall.distribution.adapter.out.persistence.entity.DistributorEntity;
import com.mall.distribution.adapter.out.persistence.mapper.DistributorMapper;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.distributor.Distributor;
import com.mall.distribution.domain.distributor.DistributorId;
import com.mall.distribution.domain.distributor.DistributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 分销商仓储实现
 */
@Repository
@RequiredArgsConstructor
public class DistributorRepositoryImpl implements DistributorRepository {
    
    private final DistributorMapper distributorMapper;
    private final DistributorConverter distributorConverter;
    
    @Override
    public void save(Distributor distributor) {
        DistributorEntity entity = distributorConverter.toEntity(distributor);
        
        if (entity.getDistributorId() == null) {
            // 新增
            distributorMapper.insert(entity);
            // 设置生成的ID
            distributor.setDistributorId(new DistributorId(entity.getDistributorId()));
        } else {
            // 更新
            distributorMapper.updateById(entity);
        }
    }
    
    @Override
    public Optional<Distributor> findById(DistributorId distributorId) {
        DistributorEntity entity = distributorMapper.selectById(distributorId.getValue());
        return Optional.ofNullable(distributorConverter.toDomain(entity));
    }
    
    @Override
    public Optional<Distributor> findByUserId(Long userId) {
        DistributorEntity entity = distributorMapper.findByUserId(userId);
        return Optional.ofNullable(distributorConverter.toDomain(entity));
    }
    
    @Override
    public List<Distributor> findByQuery(DistributorQuery query) {
        List<DistributorEntity> entities = distributorMapper.findByQuery(query);
        return entities.stream()
            .map(distributorConverter::toDomain)
            .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsByUserId(Long userId) {
        return distributorMapper.existsByUserId(userId);
    }
    
    @Override
    public boolean existsByPhone(String phone) {
        return distributorMapper.existsByPhone(phone);
    }
    
    @Override
    public boolean existsByPhoneAndIdNot(String phone, Long distributorId) {
        return distributorMapper.existsByPhoneAndIdNot(phone, distributorId);
    }
    
    @Override
    public boolean existsByIdCard(String idCard) {
        return distributorMapper.existsByIdCard(idCard);
    }
    
    @Override
    public boolean existsByIdCardAndIdNot(String idCard, Long distributorId) {
        return distributorMapper.existsByIdCardAndIdNot(idCard, distributorId);
    }
    
    @Override
    public boolean existsById(DistributorId distributorId) {
        return distributorMapper.existsById(distributorId);
    }
}