package com.cjlu.mapper;

import com.cjlu.model.OrderPojo;

import java.util.List;

public interface OrderMapper {
    public void save(OrderPojo orderPojo);
    public List<OrderPojo> findAllByUid(int index,int limit,long uid);
    public int countByUid(long uid);
    public List<OrderPojo> findAll(int index,int limit);
    public void updateState(long id);
    public int count();
}
