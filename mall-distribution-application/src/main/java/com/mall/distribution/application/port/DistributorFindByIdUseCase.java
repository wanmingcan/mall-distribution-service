package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.distributor.Distributor;

public interface DistributorFindByIdUseCase {
    /**
     * 根据ID查找分销商
     * @author wanmingcan
     */
    Distributor findById(Long distributorId);
}
