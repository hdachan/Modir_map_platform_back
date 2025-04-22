package com.example.modir.common.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtUser {
    private String uuid; // JWT의 sub 클레임
    private String username;
    private String email;
}