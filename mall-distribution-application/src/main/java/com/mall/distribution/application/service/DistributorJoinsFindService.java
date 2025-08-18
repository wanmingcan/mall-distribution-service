package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorJoinsFindUseCase;
import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.model.join.DistributorJoin;

import java.util.List;

public class DistributorJoinsFindService implements DistributorJoinsFindUseCase {
    @Override
    public List<DistributorJoin> findDistributorJoins(DistributorJoinQuery query) {
        return List.of();
    }
}
