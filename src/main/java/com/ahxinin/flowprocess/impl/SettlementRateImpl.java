package com.ahxinin.flowprocess.impl;

import com.ahxinin.flowprocess.IProcessOrder;
import com.ahxinin.flowprocess.Order;
import com.ahxinin.flowprocess.ProcessLink;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 结算比例
 * @date : 2022-01-05
 */
@Service("settlementRate")
public class SettlementRateImpl implements IProcessOrder {

    @Override
    public int process(Order order, ProcessLink processLink) {
        System.out.println("settlementRate process");
        return IProcessOrder.SUCCESS;
    }
}
