package com.mall.distribution.application.service;

import com.mall.distribution.application.port.CommissionBalanceUpdateUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 更新佣金余额应用服务
 * @author wanmingcan
 */
@Service
public class CommissionBalanceUpdateService implements CommissionBalanceUpdateUseCase{
    @Override
    public void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy) {

    }
}
