package com.mall.distribution.application.port;

import com.mall.distribution.domain.model.join.DistributorJoin;

public interface DistributorJoinFindByIdUseCase {
    /**
     * 根据ID查找申请
     */
    DistributorJoin findById(Long joinId);
}
