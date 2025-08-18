package com.mall.distribution.application.service;

import com.mall.distribution.application.port.DistributorJoinCreateUseCase;
import com.mall.distribution.application.port.DistributorJoinFindByIdUseCase;
import com.mall.distribution.domain.model.join.DistributorJoin;
import org.springframework.stereotype.Service;

/**
 * 根据ID查找申请
 * @author wanmingcan
 */
@Service
public class DistributorJoinFindByIdService implements DistributorJoinFindByIdUseCase {
    @Override
    public DistributorJoin findById(Long joinId) {
        return null;
    }
}
