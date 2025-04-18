package com.example.modir.common.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping("/hello")
    public ResponseEntity<String> privateHello() {
        return ResponseEntity.ok("🎉 인증된 사용자만 볼 수 있는 응답입니다!");
    }
}
