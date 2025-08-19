package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.distributor.Distributor;
/**
 * 根据用户ID查找分销商
 * @author wanmingcan
 */
public interface DistributorFindByUserIdUseCase {

    Distributor findByUserId(Long userId);
}
