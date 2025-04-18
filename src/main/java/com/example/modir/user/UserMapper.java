package com.example.modir.user;


import com.example.modir.user.model.InsUserReq;
import com.example.modir.user.model.SellUserRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int InsUser(InsUserReq req);

    SellUserRes sellUser();
    int countUserByUuid(String uuid);
}