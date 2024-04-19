package com.example.demo.entity;

import lombok.Getter;

import java.util.Date;
import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2024-04-18 21:58:11
 */
@Getter
public class TOrder implements Serializable {
    private static final long serialVersionUID = -65227186568893020L;

    private Long id;
    /**
     * order_name
     */
    private String orderName;
    /**
     * price
     */
    private Long price;
    /**
     * time
     */
    private Date createTime;
    /**
     * time
     */
    private Date updateTime;


    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

