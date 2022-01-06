package com.ahxinin.ddd.architecture.application;

import com.ahxinin.ddd.architecture.domain.types.AccountNumber;
import java.util.Currency;

/**
 * @author : hexin
 * @description: 转账服务
 * @date : 2022-01-06
 */
public interface TransferService {

    boolean transfer(Long sourceUserId, AccountNumber targetAccountNumber, Long targetAmount, Currency targetCurrency);
}
