package com.cjlu.controller;

import com.cjlu.feign.OrderFeign;
import com.cjlu.model.MenuPojo;
import com.cjlu.model.OrderPojo;
import com.cjlu.model.UserPojo;
import com.cjlu.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @GetMapping("/findAllByUid")
    @ResponseBody
    public ApiResult findByUid(HttpSession session, @RequestParam("page") int page, @RequestParam("limit") int limit){
        UserPojo userPojo = (UserPojo)session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findByUid(index,limit,userPojo.getId());
    }
    @GetMapping("/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return orderFeign.findAll(index,limit);
    }
    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") long id){
         orderFeign.updateState(id);
         return "redirect:/menu/redirect/order_handler";
    }

}
