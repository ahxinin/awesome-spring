package com.ahxinin.ddd.architecture.domain.entity;

import com.ahxinin.ddd.architecture.domain.exception.DailyLimitException;
import com.ahxinin.ddd.architecture.domain.exception.InsufficientBalanceException;
import com.ahxinin.ddd.architecture.domain.exception.InvalidCurrencyException;
import com.ahxinin.ddd.architecture.domain.types.AccountNumber;
import com.ahxinin.ddd.architecture.domain.types.Money;
import java.util.Currency;
import lombok.Data;

/**
 * @author : hexin
 * @description: 账户
 * @date : 2022-01-06
 */
@Data
public class Account {

    private Long accountId;

    private AccountNumber accountNumber;

    private Long userId;

    private Money available;

    private Money dailyLimit;

    public Currency getCurrency(){
        return available.getCurrency();
    }

    /**
     * 转入
     */
    public void deposit(Money money){
        if (!this.getCurrency().equals(money.getCurrency())){
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

    /**
     * 转出
     */
    public void withdraw(Money money){
        if (this.available.compareTo(money) < 0){
            throw new InsufficientBalanceException();
        }
        if (this.dailyLimit.compareTo(money) < 0){
            throw new DailyLimitException();
        }
        this.available = this.available.subtract(money);
    }
}
