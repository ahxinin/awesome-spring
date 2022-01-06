package com.ahxinin.ddd.objectbehavior;

import java.math.BigDecimal;
import java.util.Currency;
import lombok.Value;

/**
 * @author : hexin
 * @description: 支付金额
 * @date : 2022-01-05
 */
@Value
public class Money {

    /**
     * 金额
     */
    BigDecimal amount;

    /**
     * 货币
     */
    Currency currency;

    public Money(BigDecimal amount, Currency currency){
        this.amount = amount;
        this.currency = currency;
    }
}
