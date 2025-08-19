package com.mall.distribution.adapter.out.persistence.repository;

import com.mall.distribution.adapter.out.persistence.converter.DistributorJoinConverter;
import com.mall.distribution.adapter.out.persistence.entity.DistributorJoinEntity;
import com.mall.distribution.adapter.out.persistence.mapper.DistributorJoinMapper;
import com.mall.distribution.application.query.DistributorJoinQuery;

import com.mall.distribution.domain.model.join.DistributorJoin;
import com.mall.distribution.domain.repository.DistributorJoinRepository;
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
    public DistributorJoin save(DistributorJoin distributorJoin) {
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
        return distributorJoin;
    }

    @Override
    public Optional<DistributorJoin> findByMemberId(Long memberId) {
        return Optional.empty();
    }

    @Override
    public Optional<DistributorJoin> findByIdCartNumber(String idCartNumber) {
        return Optional.empty();
    }

    @Override
    public List<DistributorJoin> findAll() {
        return List.of();
    }

    @Override
    public List<DistributorJoin> findByState(Integer state) {
        return List.of();
    }

    @Override
    public boolean existsByMemberId(Long memberId) {
        return false;
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

    @Override
    public boolean existsByIdCartNumber(String idCartNumber) {
        return false;
    }

    @Override
    public void deleteByMemberId(Long memberId) {

    }
}
