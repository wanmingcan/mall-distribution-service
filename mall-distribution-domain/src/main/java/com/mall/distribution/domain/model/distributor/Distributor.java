package com.mall.distribution.domain.model.distributor;

import com.mall.distribution.domain.event.DistributorCreatedEvent;
import com.mall.distribution.domain.event.DistributorUpdatedEvent;
import com.mall.distribution.domain.event.CommissionUpdatedEvent;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 分销商聚合根
 * 管理分销商的基本信息、佣金账户和业务状态
 */
@Data
public class Distributor {

    private DistributorId distributorId;
    private Long userId;
    private String distributorName;
    private String phone;
    private String idCard;
    private String idCardFront;
    private String idCardBack;
    private String bankCard;
    private String bankName;
    private String bankBranch;
    private BigDecimal commissionBalance;

    /**
     * 累计佣金
     */
    private BigDecimal totalCommission;

    /**
     * 状态 (0-禁用, 1-启用)
     */
    private Integer status;
    private String accountType;
    private String bankAccountName;
    private String bankAccountNumber;
    private String bindEmail;
    private String bindPhone;
    private BigDecimal commissionAvailable;
    private BigDecimal commissionFreeze;
    private Integer defaultFavoritesId;
    private BigDecimal distributionAmount;
    private Integer distributionOrdersCount;
    private String idCartBackImage;
    private String idCartFrontImage;
    private String idCartHandImage;
    private String idCartNumber;
    private LocalDateTime joinInTime;
    private LocalDateTime lastLoginTime;
    private Integer memberId;
    private String memberName;
    private BigDecimal payCommission;
    private String payPerson;
    private String realName;
    private Integer state;
    private BigDecimal unpayCommission;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean isDeleted;

    // 领域事件列表
    private List<Object> domainEvents = new ArrayList<>();

    public Distributor(DistributorId distributorId, Long userId, String distributorName, String phone, String idCard, String idCardFront, String idCardBack, String bankCard, String bankName, String bankBranch, BigDecimal commissionBalance, BigDecimal totalCommission, Integer status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
    }

    public Distributor() {

    }

    /**
     * 创建分销商
     */
    public static Distributor create(String accountType, String bankAccountName, String bankAccountNumber,
                                   String bindEmail, String bindPhone, String idCartNumber, Integer memberId,
                                   String memberName, String realName, String payPerson) {
        Distributor distributor = new Distributor();
        distributor.setAccountType(accountType);
        distributor.setBankAccountName(bankAccountName);
        distributor.setBankAccountNumber(bankAccountNumber);
        distributor.setBindEmail(bindEmail);
        distributor.setBindPhone(bindPhone);
        distributor.setIdCartNumber(idCartNumber);
        distributor.setMemberId(memberId);
        distributor.setMemberName(memberName);
        distributor.setRealName(realName);
        distributor.setPayPerson(payPerson);
        distributor.setCommissionAvailable(BigDecimal.ZERO);
        distributor.setCommissionFreeze(BigDecimal.ZERO);
        distributor.setDistributionAmount(BigDecimal.ZERO);
        distributor.setDistributionOrdersCount(0);
        distributor.setPayCommission(BigDecimal.ZERO);
        distributor.setUnpayCommission(BigDecimal.ZERO);
        distributor.setState(1); // 1-正常状态
        distributor.setJoinInTime(LocalDateTime.now());
        distributor.setCreatedAt(LocalDateTime.now());
        distributor.setIsDeleted(false);

        // 添加领域事件
        distributor.addDomainEvent(new DistributorCreatedEvent(distributor.getDistributorId()));

        return distributor;
    }

    /**
     * 更新分销商信息
     */
    public void update(String accountType, String bankAccountName, String bankAccountNumber,
                      String bindEmail, String bindPhone, String realName, String payPerson) {
        this.accountType = accountType;
        this.bankAccountName = bankAccountName;
        this.bankAccountNumber = bankAccountNumber;
        this.bindEmail = bindEmail;
        this.bindPhone = bindPhone;
        this.realName = realName;
        this.payPerson = payPerson;
        this.updatedAt = LocalDateTime.now();

        // 添加领域事件
        this.addDomainEvent(new DistributorUpdatedEvent(this.distributorId));
    }

    /**
     * 更新身份证信息
     */
    public void updateIdCardInfo(String idCartFrontImage, String idCartBackImage, String idCartHandImage) {
        this.idCartFrontImage = idCartFrontImage;
        this.idCartBackImage = idCartBackImage;
        this.idCartHandImage = idCartHandImage;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新状态
     */
    public void updateState(Integer state) {
        this.state = state;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 增加可用佣金
     */
    public void addAvailableCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.commissionAvailable = this.commissionAvailable.add(amount);
            this.updatedAt = LocalDateTime.now();

            // 添加领域事件
            this.addDomainEvent(new CommissionUpdatedEvent(this.distributorId, amount, "ADD_AVAILABLE"));
        }
    }

    /**
     * 减少可用佣金
     */
    public void reduceAvailableCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && this.commissionAvailable.compareTo(amount) >= 0) {
            this.commissionAvailable = this.commissionAvailable.subtract(amount);
            this.updatedAt = LocalDateTime.now();

            // 添加领域事件
            this.addDomainEvent(new CommissionUpdatedEvent(this.distributorId, amount, "REDUCE_AVAILABLE"));
        }
    }

    /**
     * 冻结佣金
     */
    public void freezeCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && this.commissionAvailable.compareTo(amount) >= 0) {
            this.commissionAvailable = this.commissionAvailable.subtract(amount);
            this.commissionFreeze = this.commissionFreeze.add(amount);
            this.updatedAt = LocalDateTime.now();

            // 添加领域事件
            this.addDomainEvent(new CommissionUpdatedEvent(this.distributorId, amount, "FREEZE"));
        }
    }

    /**
     * 解冻佣金
     */
    public void unfreezeCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && this.commissionFreeze.compareTo(amount) >= 0) {
            this.commissionFreeze = this.commissionFreeze.subtract(amount);
            this.commissionAvailable = this.commissionAvailable.add(amount);
            this.updatedAt = LocalDateTime.now();

            // 添加领域事件
            this.addDomainEvent(new CommissionUpdatedEvent(this.distributorId, amount, "UNFREEZE"));
        }
    }

    /**
     * 更新最后登录时间
     */
    public void updateLastLoginTime() {
        this.lastLoginTime = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 增加分销订单数量
     */
    public void incrementOrdersCount() {
        this.distributionOrdersCount++;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 逻辑删除
     */
    public void delete() {
        this.isDeleted = true;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 恢复
     */
    public void restore() {
        this.isDeleted = false;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 添加领域事件
     */
    public void addDomainEvent(Object event) {
        this.domainEvents.add(event);
    }

    /**
     * 获取领域事件
     */
    public List<Object> getDomainEvents() {
        return new ArrayList<>(this.domainEvents);
    }

    /**
     * 清除领域事件
     */
    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}
