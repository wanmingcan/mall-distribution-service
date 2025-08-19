package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.distributor.Distributor;
/**
 * 根据ID查找分销商
 * @author wanmingcan
 */
public interface DistributorFindByIdUseCase {

    Distributor findById(Long distributorId);
}
