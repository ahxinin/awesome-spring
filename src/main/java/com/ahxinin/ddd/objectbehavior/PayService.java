package com.ahxinin.ddd.objectbehavior;

import java.math.BigDecimal;
import java.util.Currency;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 支付服务
 * @date : 2022-01-05
 */
@Service
public class PayService {

    @Resource
    private BankService bankService;

    @Resource
    private ExchangeService exchangeService;

    public void pay(Money money, Long receiverId, Currency targetCurrency){
        ExchangeRate rate = exchangeService.getRate(money.getCurrency(), targetCurrency);
        Money targetMoney = rate.exchange(money);
        bankService.transfer(targetMoney, receiverId);
    }
}
