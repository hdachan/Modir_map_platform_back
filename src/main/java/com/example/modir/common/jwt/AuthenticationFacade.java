package com.example.modir.common.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//이 클래스는 Spring Security의 SecurityContextHolder에서 현재 인증된 사용자의 정보를 가져오는 역할을 합니다.

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    public JwtUser getSignedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUserDetails) {
            return ((MyUserDetails) principal).getJwtUser();
        }
        return null;
    }

    public String getSignedUserUuid() {
        JwtUser jwtUser = getSignedUser();
        return jwtUser != null ? jwtUser.getUuid() : null;
    }
}
