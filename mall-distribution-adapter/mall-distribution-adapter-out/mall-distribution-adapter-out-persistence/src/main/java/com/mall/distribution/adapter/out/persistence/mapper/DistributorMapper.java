package com.mall.distribution.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.distribution.adapter.out.persistence.entity.DistributorEntity;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.domain.model.distributor.DistributorId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分销商Mapper
 */
@Mapper
public interface DistributorMapper extends BaseMapper<DistributorEntity> {

    /**
     * 根据用户ID查找分销商
     */
    DistributorEntity findByUserId(@Param("userId") Long userId);

    /**
     * 检查用户是否已是分销商
     */
    boolean existsByUserId(@Param("userId") Long userId);

    /**
     * 检查手机号是否已存在
     */
    boolean existsByPhone(@Param("phone") String phone);

    /**
     * 检查手机号是否已被其他分销商使用
     */
    boolean existsByPhoneAndIdNot(@Param("phone") String phone, @Param("distributorId") Long distributorId);

    /**
     * 检查身份证号是否已存在
     */
    boolean existsByIdCard(@Param("idCard") String idCard);

    /**
     * 检查身份证号是否已被其他分销商使用
     */
    boolean existsByIdCardAndIdNot(@Param("idCard") String idCard, @Param("distributorId") Long distributorId);

    /**
     * 根据查询条件查找分销商列表
     */
    List<DistributorEntity> findByQuery(@Param("query") DistributorQuery query);

    boolean existsById(DistributorId distributorId);
}
