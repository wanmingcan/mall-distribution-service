package com.mall.distribution.application.service;

import com.mall.distribution.application.port.TotalCommissionUpdateUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 更新累计佣金应用服务
 */
@Service
public class TotalCommissionUpdateService implements TotalCommissionUpdateUseCase{
    @Override
    public void updateTotalCommission(Long distributorId, BigDecimal amount, String updatedBy) {

    }
}
