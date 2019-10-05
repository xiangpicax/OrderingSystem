package com.cjlu.controller;

import com.cjlu.feign.OrderFeign;
import com.cjlu.model.MenuPojo;
import com.cjlu.model.OrderPojo;
import com.cjlu.model.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/save/{mid}")
    public String save(HttpSession session, @PathVariable("mid") int mid){
        OrderPojo orderPojo = new OrderPojo();
        UserPojo userPojo = (UserPojo) session.getAttribute("user");
        MenuPojo menuPojo = new MenuPojo();
        menuPojo.setId(mid);
        orderPojo.setUser(userPojo);
        orderPojo.setMenu(menuPojo);
        orderFeign.save(orderPojo);
        return "index";
    }
}
