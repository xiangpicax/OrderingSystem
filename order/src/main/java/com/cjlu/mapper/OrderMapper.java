package com.cjlu.mapper;

import com.cjlu.model.OrderPojo;

import java.util.List;

public interface OrderMapper {
    public void save(OrderPojo orderPojo);
    public List<OrderPojo> findAll(int index,int limit);
}
