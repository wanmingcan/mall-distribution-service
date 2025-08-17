package com.mall.distribution.domain.event;

import com.mall.distribution.domain.model.distributor.DistributorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 分销商创建事件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributorCreatedEvent {
    private DistributorId distributorId;
    private LocalDateTime occurredOn = LocalDateTime.now();
    
    public DistributorCreatedEvent(DistributorId distributorId) {
        this.distributorId = distributorId;
        this.occurredOn = LocalDateTime.now();
    }
}