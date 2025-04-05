package com.example.modir.user;


import com.example.modir.user.model.InsUserReq;
import com.example.modir.user.model.SellUserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public int postUser(InsUserReq req){
        int res = userMapper.InsUser(req);

        return res;
    }

    public SellUserRes getUser(){
        SellUserRes res = userMapper.sellUser();
        return res;
    }
}