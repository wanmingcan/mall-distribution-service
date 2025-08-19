package com.mall.distribution.application.port;

import java.math.BigDecimal;
/**
 * 更新累计佣金
 * @author wanmingcan
 */
public interface TotalCommissionUpdateUseCase {

    void updateTotalCommission(Long distributorId, BigDecimal amount, String updatedBy);
}
