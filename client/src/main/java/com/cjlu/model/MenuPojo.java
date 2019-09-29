package com.cjlu.model;

import lombok.Data;

@Data
public class MenuPojo {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private int tid;
}
