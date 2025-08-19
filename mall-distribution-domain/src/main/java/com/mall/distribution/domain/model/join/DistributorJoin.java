package com.mall.distribution.domain.model.join;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 分销商申请实体
 * 管理分销商的申请流程和审核状态
 */
@Data
public class DistributorJoin {

    private Long memberId;
    private String applicantName;
    private String phone;
    private String idCard;
    private String idCardFront;
    private String idCardBack;
    private String bankCard;
    private String bankName;
    private String bankBranch;
    private String reason;
    private Integer auditStatus;
    private LocalDateTime auditTime;
    private String auditBy;
    private String auditRemark;
    private String accountType;
    private String bankAccountName;
    private String bankAccountNumber;
    private LocalDateTime handleTime;
    private String idCartBackImage;
    private String idCartFrontImage;
    private String idCartHandImage;
    private String idCartNumber;
    private String joinInMessage;
    private LocalDateTime joinInTime;
    private String memberName;
    private String payPerson;
    private String realName;
    private Integer state; // 0-待审核, 1-已通过, 2-已拒绝
    private Long JoinId;
    private Long UserId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean isDeleted;

    public DistributorJoin(Long joinId, Long userId, String applicantName, String phone, String idCard, String idCardFront, String idCardBack, String bankCard, String bankName, String bankBranch, String reason, Integer auditStatus, LocalDateTime auditTime, String auditBy, String auditRemark, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
    }

    public DistributorJoin() {

    }

    /**
     * 创建分销商申请
     */
    public static DistributorJoin create(Long memberId, String accountType, String bankAccountName,
                                       String bankAccountNumber, String idCartNumber, String memberName,
                                       String realName, String payPerson, String joinInMessage) {
        DistributorJoin join = new DistributorJoin();
        join.setMemberId(memberId);
        join.setAccountType(accountType);
        join.setBankAccountName(bankAccountName);
        join.setBankAccountNumber(bankAccountNumber);
        join.setIdCartNumber(idCartNumber);
        join.setMemberName(memberName);
        join.setRealName(realName);
        join.setPayPerson(payPerson);
        join.setJoinInMessage(joinInMessage);
        join.setState(0); // 待审核
        join.setJoinInTime(LocalDateTime.now());
        join.setCreatedAt(LocalDateTime.now());
        join.setIsDeleted(false);

        return join;
    }

    public static DistributorJoin create(Long userId, String applicantName, String phone, String idCard, String idCardFront, String idCardBack, String bankCard, String bankName, String bankBranch, String reason, String createdBy) {
        return null;
    }

    /**
     * 审核通过
     */
    public void approve() {
        this.state = 1;
        this.handleTime = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 审核拒绝
     */
    public void reject() {
        this.state = 2;
        this.handleTime = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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
     * 检查是否可以审核
     */
    public boolean canProcess() {
        return this.state == 0; // 只有待审核状态才能处理
    }
}
