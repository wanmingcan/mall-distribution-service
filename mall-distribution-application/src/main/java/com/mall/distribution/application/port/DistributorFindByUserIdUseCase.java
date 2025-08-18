package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.distributor.Distributor;

public interface DistributorFindByUserIdUseCase {
    /**
     * 根据用户ID查找分销商
     * @author wanmingcan
     */
    Distributor findByUserId(Long userId);
}
