package com.ahxinin.ddd.architecture.domain.service.impl;

import com.ahxinin.ddd.architecture.domain.entity.Account;
import com.ahxinin.ddd.architecture.domain.entity.ExchangeRate;
import com.ahxinin.ddd.architecture.domain.service.AccountTransferService;
import com.ahxinin.ddd.architecture.domain.types.Money;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 转账服务
 * @date : 2022-01-06
 */
@Service
public class AccountTransferServiceImpl implements AccountTransferService {

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney,
            ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchange(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
