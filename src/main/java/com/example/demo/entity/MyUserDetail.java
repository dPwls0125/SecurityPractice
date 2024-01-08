package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetail implements UserDetails {
    private User user;
    private String email;
    private String password;
    private String auth;
    public MyUserDetail(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.auth = user.getRole();

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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

    /*
    getAuthorities() : 계정이 가지고 있는 권한 목록 반환
    getPassword() : 계정의 비밀번호 반환
    getUsername() : 계정의 이름 반환
    isAccountNonExpired() : 계정 만료 여부(false = 만료)
    isAccountNonLocked() : 계정 잠김 여부(false = 잠김)
    isCredentialNonExpired() : 계정 비밀번호 만료 여부(false = 만료)
    isEnabled() : 계정 활성화 여부(false = 비활성)
     */
}
