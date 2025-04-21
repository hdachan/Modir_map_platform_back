package com.example.modir.user;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.user.model.InsUserReq;
import com.example.modir.user.model.SellUserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResultResponse<Integer> postUser(@RequestBody InsUserReq req) {
        System.out.println("POST /user called with: " + req); // 디버깅 로그
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

    @GetMapping("/profile")
    public ResponseEntity<?> getMyProfile(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String uuid = userService.getUuidFromToken(token); // ✅ 여기서 서명검증 + UUID 추출

        // uuid로 DB 조회하거나 로직 처리
        // 예시: User user = userMapper.findById(uuid);

        return ResponseEntity.ok("UUID: " + uuid);
    }
}