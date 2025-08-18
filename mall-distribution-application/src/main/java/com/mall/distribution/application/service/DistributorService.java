package com.mall.distribution.application.service;

import com.mall.distribution.application.command.CreateDistributorCommand;
import com.mall.distribution.application.command.UpdateDistributorCommand;
import com.mall.distribution.application.port.DistributorUseCase;
import com.mall.distribution.application.query.DistributorQuery;
import com.mall.distribution.common.exception.BusinessException;

import com.mall.distribution.domain.repository.DistributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;


/**
 * 分销商应用服务
 */
@Service
@RequiredArgsConstructor
public class DistributorService implements DistributorUseCase {

    private final DistributorRepository distributorRepository;

    @Override
    @Transactional
    public Long createDistributor(CreateDistributorCommand command) {
        // 检查用户是否已是分销商
        if (distributorRepository.existsByUserId(command.getUserId())) {
            throw new BusinessException(Resp.DISTRIBUTOR_USER_ALREADY_EXISTS);
        }

        // 检查手机号是否已存在
        if (distributorRepository.existsByPhone(command.getPhone())) {
            throw new BusinessException(Resp.DISTRIBUTOR_PHONE_ALREADY_EXISTS);
        }

        // 检查身份证号是否已存在
        if (distributorRepository.existsByIdCard(command.getIdCard())) {
            throw new BusinessException(Resp.DISTRIBUTOR_ID_CARD_ALREADY_EXISTS);
        }

        // 创建分销商
        Distributor distributor = Distributor.create(
            command.getUserId(),
            command.getDistributorName(),
            command.getPhone(),
            command.getIdCard(),
            command.getIdCardFront(),
            command.getIdCardBack(),
            command.getBankCard(),
            command.getBankName(),
            command.getBankBranch(),
            command.getCreatedBy()
        );

        // 保存分销商
        distributorRepository.save(distributor);

        return distributor.getDistributorId().getValue();
    }

    @Override
    @Transactional
    public void updateDistributor(UpdateDistributorCommand command) {
        // 查找分销商
        Distributor distributor = distributorRepository.findById(new DistributorId(command.getDistributorId()))
            .orElseThrow(() -> new BusinessException(Resp.DISTRIBUTOR_NOT_FOUND));

        // 检查手机号是否已被其他分销商使用
        if (!distributor.getPhone().equals(command.getPhone()) &&
            distributorRepository.existsByPhoneAndIdNot(command.getPhone(), command.getDistributorId())) {
            throw new BusinessException(Resp.DISTRIBUTOR_PHONE_ALREADY_EXISTS);
        }

        // 检查身份证号是否已被其他分销商使用
        if (!distributor.getIdCard().equals(command.getIdCard()) &&
            distributorRepository.existsByIdCardAndIdNot(command.getIdCard(), command.getDistributorId())) {
            throw new BusinessException(Resp.DISTRIBUTOR_ID_CARD_ALREADY_EXISTS);
        }

        // 更新分销商信息
        distributor.update(
            command.getDistributorName(),
            command.getPhone(),
            command.getIdCard(),
            command.getIdCardFront(),
            command.getIdCardBack(),
            command.getBankCard(),
            command.getBankName(),
            command.getBankBranch(),
            command.getUpdatedBy()
        );

        // 保存分销商
        distributorRepository.save(distributor);
    }

    @Override
    public Distributor findById(Long distributorId) {
        return distributorRepository.findById(new DistributorId(distributorId))
            .orElseThrow(() -> new BusinessException(Resp.DISTRIBUTOR_NOT_FOUND));
    }

    @Override
    public Distributor findByUserId(Long userId) {
        return distributorRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException(Resp.DISTRIBUTOR_NOT_FOUND));
    }

    @Override
    public List<Distributor> findDistributors(DistributorQuery query) {
        return distributorRepository.findByQuery(query);
    }

    @Override
    @Transactional
    public void enableDistributor(Long distributorId, String updatedBy) {
        Distributor distributor = findById(distributorId);
        distributor.enable(updatedBy);
        distributorRepository.save(distributor);
    }

    @Override
    @Transactional
    public void disableDistributor(Long distributorId, String updatedBy) {
        Distributor distributor = findById(distributorId);
        distributor.disable(updatedBy);
        distributorRepository.save(distributor);
    }

    @Override
    @Transactional
    public void updateCommissionBalance(Long distributorId, BigDecimal amount, String updatedBy) {
        Distributor distributor = findById(distributorId);
        distributor.updateCommissionBalance(amount, updatedBy);
        distributorRepository.save(distributor);
    }

    @Override
    @Transactional
    public void updateTotalCommission(Long distributorId, BigDecimal amount, String updatedBy) {
        Distributor distributor = findById(distributorId);
        distributor.updateTotalCommission(amount, updatedBy);
        distributorRepository.save(distributor);
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return distributorRepository.existsByUserId(userId);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return distributorRepository.existsByPhone(phone);
    }

    @Override
    public boolean existsByIdCard(String idCard) {
        return distributorRepository.existsByIdCard(idCard);
    }
}
