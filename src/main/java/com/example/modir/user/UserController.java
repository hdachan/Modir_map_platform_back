package com.example.modir.user;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.user.model.InsUserReq;
import com.example.modir.user.model.SellUserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResultResponse<Integer> postUser(InsUserReq req){
        int result = userService.postUser(req);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultResponse<SellUserRes> getUser(){
        SellUserRes res = userService.getUser();

        return ResultResponse.<SellUserRes>builder()
                .resultMessage("사용자 조회")
                .resultData(res)
                .build();

    }
}