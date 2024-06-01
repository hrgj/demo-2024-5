package com.example.demo.controller;


import com.example.demo.Intererceptor.Loggable;
import com.example.demo.entity.TOrder;
import com.example.demo.service.OrderService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController()
public class OrderController {


    @Resource
    private OrderService orderService;


    @GetMapping("/get/orderinfo")
    public String getOrderInfo(@RequestParam(value = "id", required = false) Long id,@RequestParam(value = "str", required = false) String name){
        TOrder order = new TOrder();
        order.setId(id);
        order.setOrderName(name);
        return orderService.getOrderInfo(order);
    }


    // 模拟的扩展词典数据（实际情况下可能从数据库或其他存储中获取）
    private static final String[] EXTRA_DICTIONARY = {
            "清华大学",
            "这里是一段测试文本",
            "只对你有感觉",
            "我有一个苹果",
            "中华人民共和国",
            "3dfdi3o",
            "华大"
    };

    // 定义一个路由来处理IK分词器的请求
    @GetMapping("get/ik_ext_dict")
    @Loggable("kjk-----")
    public String getExtDictionary(HttpServletResponse response) {
        response.setHeader("ETag", String.valueOf(EXTRA_DICTIONARY.hashCode()));
        // 将数组转换为以换行符分隔的字符串
        return String.join("\n", Arrays.asList(EXTRA_DICTIONARY));
    }

    @GetMapping("get/ik_dict")
    public String getDictionary() {
        // 将数组转换为以换行符分隔的字符串
        return String.join("\n", "");
    }

    public int installOrder(TOrder order) {
       return orderService.installOrder(order);
    }
}
