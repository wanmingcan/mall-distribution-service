package com.mall.distribution.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.distribution.adapter.out.persistence.entity.CommissionCashEntity;
import com.mall.distribution.application.query.CommissionCashQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 佣金提现Mapper
 */
@Mapper
public interface CommissionCashMapper extends BaseMapper<CommissionCashEntity> {
    
    /**
     * 根据查询条件查找提现申请列表
     */
    List<CommissionCashEntity> findByQuery(@Param("query") CommissionCashQuery query);
}