package com.ahxinin.ddd.architecture.domain.types;

import java.util.Currency;
import javax.swing.plaf.SpinnerUI;
import lombok.Data;

/**
 * @author : hexin
 * @description: 金额
 * @date : 2022-01-06
 */
@Data
public class Money implements Comparable{

    private Long amount;

    private Currency currency;

    public Money(Long amount, Currency currency){
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money money){
        Long totalAmount = amount + money.getAmount();
        return new Money(totalAmount, currency);
    }

    public Money subtract(Money money){
        Long newAmount = amount = money.getAmount();
        return new Money(newAmount, currency);
    }

    @Override
    public int compareTo(Object object) {
        Money money = (Money) object;
        return Long.compare(this.amount, money.getAmount());
    }
}
