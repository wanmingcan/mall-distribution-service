package com.mall.distribution.adapter.in.web.controller;

import com.mall.distribution.adapter.in.web.dto.CreateCommissionCashRequest;
import com.mall.distribution.application.command.CreateCommissionCashCommand;
import com.mall.distribution.application.port.CommissionCashUseCase;
import com.mall.distribution.application.query.CommissionCashQuery;
import com.mall.distribution.common.util.Result;
import com.mall.distribution.domain.commission.CommissionCash;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 佣金提现控制器
 */
@RestController
@RequestMapping("/api/distribution/commission-cashes")
@RequiredArgsConstructor
@Tag(name = "佣金提现管理", description = "佣金提现相关接口")
public class CommissionCashController {
    
    private final CommissionCashUseCase commissionCashUseCase;
    
    @PostMapping
    @Operation(summary = "创建佣金提现申请", description = "创建新的佣金提现申请")
    public Result<Long> createCommissionCash(@Valid @RequestBody CreateCommissionCashRequest request) {
        CreateCommissionCashCommand command = new CreateCommissionCashCommand(
            request.getDistributorId(),
            request.getCashAmount(),
            request.getBankCard(),
            request.getBankName(),
            request.getBankBranch(),
            "system" // TODO: 从当前用户上下文获取
        );
        
        Long cashId = commissionCashUseCase.createCommissionCash(command);
        return Result.success(cashId, "佣金提现申请创建成功");
    }
    
    @GetMapping("/{cashId}")
    @Operation(summary = "根据ID查询提现申请", description = "根据提现ID查询提现申请详情")
    public Result<CommissionCash> getCommissionCash(
        @Parameter(description = "提现ID") @PathVariable Long cashId) {
        
        CommissionCash commissionCash = commissionCashUseCase.findById(cashId);
        return Result.success(commissionCash);
    }
    
    @GetMapping
    @Operation(summary = "查询提现申请列表", description = "根据条件查询提现申请列表")
    public Result<List<CommissionCash>> getCommissionCashes(
        @Parameter(description = "提现ID") @RequestParam(required = false) Long cashId,
        @Parameter(description = "分销商ID") @RequestParam(required = false) Long distributorId,
        @Parameter(description = "提现状态") @RequestParam(required = false) Integer cashStatus,
        @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
        @Parameter(description = "页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        
        CommissionCashQuery query = new CommissionCashQuery(
            cashId, distributorId, cashStatus, pageNum, pageSize
        );
        
        List<CommissionCash> commissionCashes = commissionCashUseCase.findCommissionCashes(query);
        return Result.success(commissionCashes);
    }
    
    @PutMapping("/{cashId}/approve")
    @Operation(summary = "审核通过提现申请", description = "审核通过指定的提现申请")
    public Result<Void> approveCash(
        @Parameter(description = "提现ID") @PathVariable Long cashId,
        @Parameter(description = "审核备注") @RequestParam(required = false) String auditRemark) {
        
        commissionCashUseCase.approveCash(cashId, "system", auditRemark);
        return Result.success("提现申请审核通过");
    }
    
    @PutMapping("/{cashId}/reject")
    @Operation(summary = "拒绝提现申请", description = "拒绝指定的提现申请")
    public Result<Void> rejectCash(
        @Parameter(description = "提现ID") @PathVariable Long cashId,
        @Parameter(description = "审核备注") @RequestParam(required = false) String auditRemark) {
        
        commissionCashUseCase.rejectCash(cashId, "system", auditRemark);
        return Result.success("提现申请已拒绝");
    }
    
    @PutMapping("/{cashId}/pay")
    @Operation(summary = "支付提现申请", description = "支付指定的提现申请")
    public Result<Void> payCash(
        @Parameter(description = "提现ID") @PathVariable Long cashId,
        @Parameter(description = "支付单号") @RequestParam String paymentNo) {
        
        commissionCashUseCase.payCash(cashId, paymentNo, "system");
        return Result.success("提现申请支付成功");
    }
}