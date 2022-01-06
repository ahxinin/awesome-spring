package com.ahxinin.ddd.architecture.domain.service;

import com.ahxinin.ddd.architecture.domain.entity.Account;
import com.ahxinin.ddd.architecture.domain.entity.ExchangeRate;
import com.ahxinin.ddd.architecture.domain.types.Money;

/**
 * @author : hexin
 * @description: 账户间转账服务
 * @date : 2022-01-06
 */
public interface AccountTransferService {

    /**
     * 转账
     * @param sourceAccount 来源账户
     * @param targetAccount 目标账户
     * @param targetMoney   转入金额
     * @param exchangeRate  汇率
     */
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
