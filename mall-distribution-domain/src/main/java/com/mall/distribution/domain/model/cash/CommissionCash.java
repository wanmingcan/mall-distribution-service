package com.mall.distribution.domain.model.cash;



import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 佣金提现实体
 * 管理分销商的佣金提现申请和处理流程
 */
@Data
public class CommissionCash {

    private Long cashId;
    private String accountType;
    private LocalDateTime addTime;
    private Integer adminId;
    private String adminName;
    private BigDecimal amount;
    private String bankAccountName;
    private String bankAccountNumber;
    private String bindPhone;
    private String cashSn;
    private Integer distributorId;
    private String idCartNumber;
    private Integer memberId;
    private String memberName;
    private String payPerson;
    private LocalDateTime payTime;
    private String realName;
    private String refuseReason;
    private Integer state; // 0-待处理, 1-已通过, 2-已拒绝, 3-已支付
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Boolean isDeleted;

    /**
     * 创建佣金提现申请
     */
    public static CommissionCash create(Integer distributorId, Integer memberId, String memberName,
                                      BigDecimal amount, String accountType, String bankAccountName,
                                      String bankAccountNumber, String bindPhone, String idCartNumber,
                                      String realName, String payPerson) {
        CommissionCash cash = new CommissionCash();
        cash.setDistributorId(distributorId);
        cash.setMemberId(memberId);
        cash.setMemberName(memberName);
        cash.setAmount(amount);
        cash.setAccountType(accountType);
        cash.setBankAccountName(bankAccountName);
        cash.setBankAccountNumber(bankAccountNumber);
        cash.setBindPhone(bindPhone);
        cash.setIdCartNumber(idCartNumber);
        cash.setRealName(realName);
        cash.setPayPerson(payPerson);
        cash.setCashSn(generateCashSn());
        cash.setState(0); // 待处理
        cash.setAddTime(LocalDateTime.now());
        cash.setCreatedAt(LocalDateTime.now());
        cash.setIsDeleted(false);

        return cash;
    }

    /**
     * 审核通过
     */
    public void approve(Integer adminId, String adminName) {
        this.state = 1;
        this.adminId = adminId;
        this.adminName = adminName;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 审核拒绝
     */
    public void reject(Integer adminId, String adminName, String refuseReason) {
        this.state = 2;
        this.adminId = adminId;
        this.adminName = adminName;
        this.refuseReason = refuseReason;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 标记为已支付
     */
    public void markAsPaid(String payPerson) {
        this.state = 3;
        this.payPerson = payPerson;
        this.payTime = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 检查是否可以审核
     */
    public boolean canProcess() {
        return this.state == 0; // 只有待处理状态才能审核
    }

    /**
     * 检查是否可以支付
     */
    public boolean canPay() {
        return this.state == 1; // 只有已通过状态才能支付
    }

    /**
     * 生成提现单号
     */
    private static String generateCashSn() {
        return "CASH" + System.currentTimeMillis();
    }
}
