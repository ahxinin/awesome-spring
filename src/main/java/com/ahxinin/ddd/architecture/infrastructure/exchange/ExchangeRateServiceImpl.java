package com.ahxinin.ddd.architecture.infrastructure.exchange;

import com.ahxinin.ddd.architecture.domain.entity.ExchangeRate;
import com.ahxinin.ddd.architecture.domain.external.ExchangeRateService;
import java.util.Currency;

/**
 * @author : hexin
 * @description: 货币汇率
 * @date : 2022-01-06
 */
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        return null;
    }
}
