package com.mall.distribution.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.distribution.adapter.out.persistence.entity.DistributorJoinEntity;
import com.mall.distribution.application.query.DistributorJoinQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分销商申请Mapper
 */
@Mapper
public interface DistributorJoinMapper extends BaseMapper<DistributorJoinEntity> {
    
    /**
     * 检查用户是否有待审核的申请
     */
    boolean existsPendingByUserId(@Param("userId") Long userId);
    
    /**
     * 根据查询条件查找申请列表
     */
    List<DistributorJoinEntity> findByQuery(@Param("query") DistributorJoinQuery query);
}