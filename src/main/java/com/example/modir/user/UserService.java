package com.example.modir.user;


import com.example.modir.common.excprion.CustomException;
import com.example.modir.user.model.InsUserReq;
import com.example.modir.user.model.SellUserRes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    @Value("${jwt.secret}")
    private String jwtSecret;

    private Key jwtKey;

    @PostConstruct
    public void init() {
        this.jwtKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public int postUser(InsUserReq req) {
        try {
            System.out.println("Inserting user: " + req); // 디버깅 로그
            int res = userMapper.InsUser(req);
            return res;
        } catch (Exception e) {
            System.err.println("Error inserting user: " + e.getMessage());
            throw new RuntimeException("Failed to register user: " + e.getMessage());
        }
    }

    public SellUserRes getUser(){
        SellUserRes res = userMapper.sellUser();
        return res;
    }

    public String getUuidFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(jwtKey)   // ✅ 서명 검증
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String uuid = claims.getSubject();

            int count = userMapper.countUserByUuid(uuid); // 사용자 수 확인

            if(count == 0 || count > 1){
                throw new CustomException("사용자가 없습니다.", HttpStatus.BAD_REQUEST);
            }
            return uuid; // ✅ sub = 유저 UUID
        } catch (JwtException e) {
            throw new RuntimeException("유효하지 않은 JWT 토큰입니다.", e);
        }
    }
}