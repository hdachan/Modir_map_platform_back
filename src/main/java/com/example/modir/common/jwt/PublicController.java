package com.example.modir.common.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/public/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, 인증 없이 접근 성공!");
    }
}

