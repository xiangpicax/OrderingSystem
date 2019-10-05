package com.cjlu.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserPojo {
    private  long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;

}
