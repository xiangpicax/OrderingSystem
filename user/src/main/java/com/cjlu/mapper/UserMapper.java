package com.cjlu.mapper;

import com.cjlu.model.UserPojo;


import java.util.List;

public interface UserMapper {
    public List<UserPojo> findAll(int index, int limit);
    public long count();
    public void save(UserPojo userPojo);
    public UserPojo findById(long id);
    public void update(UserPojo user);
    public void deleteById(long id);

}
