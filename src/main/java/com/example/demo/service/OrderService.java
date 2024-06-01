package com.example.demo.service;

import com.example.demo.entity.TOrder;

public interface OrderService {
    String getOrderInfo(TOrder order);

    int installOrder(TOrder order);
}
