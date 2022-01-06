package com.ahxinin.ddd.architecture.domain.external;

import com.ahxinin.ddd.architecture.domain.entity.ExchangeRate;
import java.util.Currency;

/**
 * @author : hexin
 * @description: 货币转换汇率
 * @date : 2022-01-06
 */
public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);
}
