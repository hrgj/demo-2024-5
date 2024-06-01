package com.example.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.demo.dao.OrderDao;
import com.example.demo.entity.TOrder;
import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class orderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Override
    public String getOrderInfo(TOrder order) {
        List<TOrder> list = orderDao.getOrderInfo(order);
        return JSON.toJSONString(list);
    }

    @Override
    public int installOrder(TOrder order) {
        return orderDao.insert(order);
    }
}
