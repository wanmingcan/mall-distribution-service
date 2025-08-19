package com.mall.distribution.adapter.in.web.controller;

import com.mall.distribution.adapter.in.web.dto.CreateDistributorJoinRequest;
import com.mall.distribution.application.command.CreateDistributorJoinCommand;
import com.mall.distribution.application.port.*;
import com.mall.distribution.application.query.DistributorJoinQuery;
import com.mall.distribution.common.Result;
import com.mall.distribution.domain.model.join.DistributorJoin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分销商申请控制器
 * @author wanmingcan
 */
@RestController
@RequestMapping("/api/distribution/distributor-joins")
@RequiredArgsConstructor
@Tag(name = "分销商申请管理", description = "分销商申请相关接口")
public class DistributorJoinController {

    private final DistributorJoinCreateUseCase distributorJoinCreateUseCase;
    private final DistributorJoinFindByIdUseCase distributorJoinFindByIdUseCase;
    private final DistributorJoinsFindUseCase distributorJoinsFindUseCase;
    private final JoinApproveUseCase joinApproveUseCase;
    private final JoinRejectUseCase joinRejectUseCase;
    private final ExistsPendingByUserIdUseCase existsPendingByUserIdUseCase;

    @PostMapping
    @Operation(summary = "创建分销商申请", description = "创建新的分销商申请")
    public Result<Long> createDistributorJoin(@Valid @RequestBody CreateDistributorJoinRequest request) {
        CreateDistributorJoinCommand command = new CreateDistributorJoinCommand(
            request.getUserId(),
            request.getApplicantName(),
            request.getPhone(),
            request.getIdCard(),
            request.getIdCardFront(),
            request.getIdCardBack(),
            request.getBankCard(),
            request.getBankName(),
            request.getBankBranch(),
            request.getReason(),
            "system" // TODO: 从当前用户上下文获取
        );

        Long joinId = distributorJoinCreateUseCase.createDistributorJoin(command);
        return Result.success("分销商申请创建成功",joinId);
    }

    @GetMapping("/{joinId}")
    @Operation(summary = "根据ID查询申请", description = "根据申请ID查询申请详情")
    public Result<DistributorJoin> getDistributorJoin(
        @Parameter(description = "申请ID") @PathVariable Long joinId) {

        DistributorJoin distributorJoin = distributorJoinFindByIdUseCase.findById(joinId);
        return Result.success(distributorJoin);
    }

    @GetMapping
    @Operation(summary = "查询申请列表", description = "根据条件查询申请列表")
    public Result<List<DistributorJoin>> getDistributorJoins(
        @Parameter(description = "申请ID") @RequestParam(required = false) Long joinId,
        @Parameter(description = "用户ID") @RequestParam(required = false) Long userId,
        @Parameter(description = "申请人姓名") @RequestParam(required = false) String applicantName,
        @Parameter(description = "手机号") @RequestParam(required = false) String phone,
        @Parameter(description = "审核状态") @RequestParam(required = false) Integer auditStatus,
        @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
        @Parameter(description = "页大小") @RequestParam(defaultValue = "10") Integer pageSize) {

        DistributorJoinQuery query = new DistributorJoinQuery(
            joinId, userId, applicantName, phone, auditStatus, pageNum, pageSize
        );

        List<DistributorJoin> distributorJoins = distributorJoinsFindUseCase.findDistributorJoins(query);
        return Result.success(distributorJoins);
    }

    @PutMapping("/{joinId}/approve")
    @Operation(summary = "审核通过申请", description = "审核通过指定的申请")
    public Result<Void> approveJoin(
        @Parameter(description = "申请ID") @PathVariable Long joinId,
        @Parameter(description = "审核备注") @RequestParam(required = false) String auditRemark) {

        joinApproveUseCase.approveJoin(joinId, "system", auditRemark);
        return Result.success();
    }

    @PutMapping("/{joinId}/reject")
    @Operation(summary = "拒绝申请", description = "拒绝指定的申请")
    public Result<Void> rejectJoin(
        @Parameter(description = "申请ID") @PathVariable Long joinId,
        @Parameter(description = "审核备注") @RequestParam(required = false) String auditRemark) {

        joinRejectUseCase.rejectJoin(joinId, "system", auditRemark);
        return Result.success();
    }

    @GetMapping("/exists/pending/user/{userId}")
    @Operation(summary = "检查用户是否有待审核申请", description = "检查指定用户是否有待审核的申请")
    public Result<Boolean> existsPendingByUserId(
        @Parameter(description = "用户ID") @PathVariable Long userId) {

        boolean exists = existsPendingByUserIdUseCase.existsPendingByUserId(userId);
        return Result.success(exists);
    }
}
