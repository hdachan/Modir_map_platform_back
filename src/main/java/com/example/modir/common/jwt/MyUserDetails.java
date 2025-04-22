package com.example.modir.common.jwt;

import com.example.modir.common.jwt.JwtUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class MyUserDetails implements UserDetails {
    private final JwtUser jwtUser;

    public MyUserDetails(JwtUser jwtUser) {
        this.jwtUser = jwtUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 필요 시 권한 구현
    }

    @Override
    public String getPassword() {
        return null; // JWT에서는 비밀번호 불필요
    }

    @Override
    public String getUsername() {
        return jwtUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
