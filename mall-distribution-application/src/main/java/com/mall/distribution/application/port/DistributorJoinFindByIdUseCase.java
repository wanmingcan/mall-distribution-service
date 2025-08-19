package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.join.DistributorJoin;
/**
 * 根据ID查找申请
 * @author wanmingcan
 */
public interface DistributorJoinFindByIdUseCase {

    DistributorJoin findById(Long joinId);
}
