package com.ahxinin.ddd.architecture.application.impl;

import com.ahxinin.ddd.architecture.application.TransferService;
import com.ahxinin.ddd.architecture.domain.entity.Account;
import com.ahxinin.ddd.architecture.domain.entity.ExchangeRate;
import com.ahxinin.ddd.architecture.domain.external.AuditMessageProducer;
import com.ahxinin.ddd.architecture.domain.external.ExchangeRateService;
import com.ahxinin.ddd.architecture.domain.message.AuditMessage;
import com.ahxinin.ddd.architecture.domain.service.AccountTransferService;
import com.ahxinin.ddd.architecture.domain.types.AccountNumber;
import com.ahxinin.ddd.architecture.domain.types.Money;
import com.ahxinin.ddd.architecture.infrastructure.repository.AccountRepository;
import java.util.Currency;
import javax.annotation.Resource;

/**
 * @author : hexin
 * @description: 转账服务
 * @date : 2022-01-06
 */
public class TransferServiceImpl implements TransferService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private ExchangeRateService exchangeRateService;

    @Resource
    private AccountTransferService accountTransferService;

    @Resource
    private AuditMessageProducer auditMessageProducer;

    @Override
    public boolean transfer(Long sourceUserId, AccountNumber targetAccountNumber, Long targetAmount,
            Currency targetCurrency) {
        Money targetMoney = new Money(targetAmount, targetCurrency);

        //查询数据
        Account sourceAccount = accountRepository.query(sourceUserId);
        Account targetAccount = accountRepository.query(targetAccountNumber);
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetAccount.getCurrency());

        //业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        //保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        //发送转账消息
        AuditMessage auditMessage = new AuditMessage(sourceAccount, targetAccount, targetMoney, sourceUserId);
        auditMessageProducer.send(auditMessage);

        return true;
    }
}
