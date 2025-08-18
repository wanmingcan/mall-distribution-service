package com.mall.distribution.application.port;

import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.model.join.DistributorJoin;

import java.util.List;

public interface DistributorJoinsFindUseCase {
    /**
     * 查询申请列表
     */
    List<DistributorJoin> findDistributorJoins(DistributorJoinQuery query);
}
