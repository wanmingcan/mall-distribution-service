package com.mall.distribution.adapter.in.web.controller;

import com.mall.distribution.adapter.in.web.dto.CreateDistributorRequest;
import com.mall.distribution.adapter.in.web.dto.UpdateDistributorRequest;
import com.mall.distribution.application.command.CreateDistributorCommand;
import com.mall.distribution.application.command.UpdateDistributorCommand;
import com.mall.distribution.application.port.DistributorUseCase;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.common.util.Result;
import com.mall.distribution.domain.distributor.Distributor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 分销商控制器
 */
@RestController
@RequestMapping("/api/distribution/distributors")
@RequiredArgsConstructor
@Tag(name = "分销商管理", description = "分销商相关接口")
public class DistributorController {
    
    private final DistributorUseCase distributorUseCase;
    
    @PostMapping
    @Operation(summary = "创建分销商", description = "创建新的分销商")
    public Result<Long> createDistributor(@Valid @RequestBody CreateDistributorRequest request) {
        CreateDistributorCommand command = new CreateDistributorCommand(
            request.getUserId(),
            request.getDistributorName(),
            request.getPhone(),
            request.getIdCard(),
            request.getIdCardFront(),
            request.getIdCardBack(),
            request.getBankCard(),
            request.getBankName(),
            request.getBankBranch(),
            "system" // TODO: 从当前用户上下文获取
        );
        
        Long distributorId = distributorUseCase.createDistributor(command);
        return Result.success(distributorId, "分销商创建成功");
    }
    
    @PutMapping("/{distributorId}")
    @Operation(summary = "更新分销商", description = "更新分销商信息")
    public Result<Void> updateDistributor(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId,
        @Valid @RequestBody UpdateDistributorRequest request) {
        
        UpdateDistributorCommand command = new UpdateDistributorCommand(
            distributorId,
            request.getDistributorName(),
            request.getPhone(),
            request.getIdCard(),
            request.getIdCardFront(),
            request.getIdCardBack(),
            request.getBankCard(),
            request.getBankName(),
            request.getBankBranch(),
            "system" // TODO: 从当前用户上下文获取
        );
        
        distributorUseCase.updateDistributor(command);
        return Result.success("分销商更新成功");
    }
    
    @GetMapping("/{distributorId}")
    @Operation(summary = "根据ID查询分销商", description = "根据分销商ID查询分销商详情")
    public Result<Distributor> getDistributor(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId) {
        
        Distributor distributor = distributorUseCase.findById(distributorId);
        return Result.success(distributor);
    }
    
    @GetMapping("/user/{userId}")
    @Operation(summary = "根据用户ID查询分销商", description = "根据用户ID查询分销商详情")
    public Result<Distributor> getDistributorByUserId(
        @Parameter(description = "用户ID") @PathVariable Long userId) {
        
        Distributor distributor = distributorUseCase.findByUserId(userId);
        return Result.success(distributor);
    }
    
    @GetMapping
    @Operation(summary = "查询分销商列表", description = "根据条件查询分销商列表")
    public Result<List<Distributor>> getDistributors(
        @Parameter(description = "分销商ID") @RequestParam(required = false) Long distributorId,
        @Parameter(description = "用户ID") @RequestParam(required = false) Long userId,
        @Parameter(description = "分销商名称") @RequestParam(required = false) String distributorName,
        @Parameter(description = "手机号") @RequestParam(required = false) String phone,
        @Parameter(description = "状态") @RequestParam(required = false) Integer status,
        @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
        @Parameter(description = "页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        
        DistributorQuery query = new DistributorQuery(
            distributorId, userId, distributorName, phone, status, pageNum, pageSize
        );
        
        List<Distributor> distributors = distributorUseCase.findDistributors(query);
        return Result.success(distributors);
    }
    
    @PutMapping("/{distributorId}/enable")
    @Operation(summary = "启用分销商", description = "启用指定的分销商")
    public Result<Void> enableDistributor(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId) {
        
        distributorUseCase.enableDistributor(distributorId, "system");
        return Result.success("分销商启用成功");
    }
    
    @PutMapping("/{distributorId}/disable")
    @Operation(summary = "禁用分销商", description = "禁用指定的分销商")
    public Result<Void> disableDistributor(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId) {
        
        distributorUseCase.disableDistributor(distributorId, "system");
        return Result.success("分销商禁用成功");
    }
    
    @PutMapping("/{distributorId}/commission-balance")
    @Operation(summary = "更新佣金余额", description = "更新分销商的佣金余额")
    public Result<Void> updateCommissionBalance(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId,
        @Parameter(description = "金额") @RequestParam BigDecimal amount) {
        
        distributorUseCase.updateCommissionBalance(distributorId, amount, "system");
        return Result.success("佣金余额更新成功");
    }
    
    @PutMapping("/{distributorId}/total-commission")
    @Operation(summary = "更新累计佣金", description = "更新分销商的累计佣金")
    public Result<Void> updateTotalCommission(
        @Parameter(description = "分销商ID") @PathVariable Long distributorId,
        @Parameter(description = "金额") @RequestParam BigDecimal amount) {
        
        distributorUseCase.updateTotalCommission(distributorId, amount, "system");
        return Result.success("累计佣金更新成功");
    }
    
    @GetMapping("/exists/user/{userId}")
    @Operation(summary = "检查用户是否已是分销商", description = "检查指定用户是否已经是分销商")
    public Result<Boolean> existsByUserId(
        @Parameter(description = "用户ID") @PathVariable Long userId) {
        
        boolean exists = distributorUseCase.existsByUserId(userId);
        return Result.success(exists);
    }
    
    @GetMapping("/exists/phone/{phone}")
    @Operation(summary = "检查手机号是否已存在", description = "检查指定手机号是否已被注册")
    public Result<Boolean> existsByPhone(
        @Parameter(description = "手机号") @PathVariable String phone) {
        
        boolean exists = distributorUseCase.existsByPhone(phone);
        return Result.success(exists);
    }
    
    @GetMapping("/exists/id-card/{idCard}")
    @Operation(summary = "检查身份证号是否已存在", description = "检查指定身份证号是否已被注册")
    public Result<Boolean> existsByIdCard(
        @Parameter(description = "身份证号") @PathVariable String idCard) {
        
        boolean exists = distributorUseCase.existsByIdCard(idCard);
        return Result.success(exists);
    }
}