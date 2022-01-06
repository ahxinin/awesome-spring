package com.ahxinin.flowprocess.impl;

import com.ahxinin.flowprocess.IProcessOrder;
import com.ahxinin.flowprocess.Order;
import com.ahxinin.flowprocess.ProcessLink;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 订单价格计算
 * @date : 2022-01-05
 */
@Service("orderPriceCalculate")
public class OrderPriceCalculateImpl implements IProcessOrder {

    @Override
    public int process(Order order, ProcessLink processLink) {
        System.out.println("orderPriceCalculate process");
        return IProcessOrder.SUCCESS;
    }
}
