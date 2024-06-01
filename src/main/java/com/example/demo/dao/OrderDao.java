package com.example.demo.dao;

import com.example.demo.entity.TOrder;

import java.util.List;

public interface OrderDao {
    List<TOrder> getOrderInfo(TOrder tOrder);

    Integer insert(TOrder order);
}
