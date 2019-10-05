package com.cjlu.feign;

import com.cjlu.model.OrderPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("order")
public interface OrderFeign {
    @PostMapping("order/save")
    public void save(OrderPojo orderPojo);
}
