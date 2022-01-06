package com.ahxinin.ddd.objectbehavior;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author : hexin
 * @description: 货币汇率
 * @date : 2022-01-05
 */
public class ExchangeRate {

    private BigDecimal rate;

    private Currency from;

    private Currency to;

    public ExchangeRate(BigDecimal rate, Currency from, Currency to){
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public Money exchange(Money fromMoney){
        BigDecimal targetAmount = fromMoney.getAmount().multiply(rate);
        return new Money(targetAmount, to);
    }

}
