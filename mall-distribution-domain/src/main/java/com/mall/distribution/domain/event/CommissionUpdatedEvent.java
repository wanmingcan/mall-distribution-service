package com.mall.distribution.domain.event;

import com.mall.distribution.domain.model.distributor.DistributorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 佣金更新事件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommissionUpdatedEvent {
    private DistributorId distributorId;
    private BigDecimal amount;
    private String operation;
    private LocalDateTime occurredOn = LocalDateTime.now();
    
    public CommissionUpdatedEvent(DistributorId distributorId, BigDecimal amount, String operation) {
        this.distributorId = distributorId;
        this.amount = amount;
        this.operation = operation;
        this.occurredOn = LocalDateTime.now();
    }
}