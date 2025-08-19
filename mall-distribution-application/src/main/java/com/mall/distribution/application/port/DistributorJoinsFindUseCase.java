package com.mall.distribution.application.port;

import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.domain.model.join.DistributorJoin;

import java.util.List;
/**
 * 查询申请列表
 * @author wanmingcan
 */
public interface DistributorJoinsFindUseCase {

    List<DistributorJoin> findDistributorJoins(DistributorJoinQuery query);
}
