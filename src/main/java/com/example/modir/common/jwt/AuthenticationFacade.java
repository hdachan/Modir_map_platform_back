package com.example.modir.common.jwt;

import com.example.modir.common.jwt.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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
