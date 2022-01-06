package com.ahxinin.ddd.objectbehavior;

import java.math.BigDecimal;
import java.util.Currency;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 汇率服务
 * @date : 2022-01-05
 */
@Service
public class ExchangeService {

    public ExchangeRate getRate(Currency currency, Currency targetCurrency){
        BigDecimal rate = new BigDecimal(1);
        return new ExchangeRate(rate, currency, targetCurrency);
    }
}
