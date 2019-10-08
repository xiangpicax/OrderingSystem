package com.cjlu.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderPojo {
    private Long id;
    private AdminPojo admin;
    private MenuPojo menu;
    private UserPojo user;
    private Date date;
    private int state;

}
