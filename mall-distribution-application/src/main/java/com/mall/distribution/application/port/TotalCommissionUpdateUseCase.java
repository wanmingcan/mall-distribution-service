package com.mall.distribution.application.port;

import java.math.BigDecimal;

public interface TotalCommissionUpdateUseCase {
    /**
     * 更新累计佣金
     * @author wanmingcan
     */
    void updateTotalCommission(Long distributorId, BigDecimal amount, String updatedBy);
}
