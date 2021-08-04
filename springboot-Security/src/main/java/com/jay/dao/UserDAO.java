package com.jay.dao;

import com.jay.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO{
    @Select("select * from users where username= #{usrname}")
    public Users getByUsername(String username);


}

