package com.example.demo.service;

import com.example.demo.entity.MyUserDetail;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try{
            user =  userRepository.findByEmail(email).orElse(null);
            if (user == null) {
                user = new User();
                user.setEmail(email);
                user.setPassword("1234");
                user.setRole("ROLE_ADMIN");
                userRepository.save(user);
            }
        } catch(Exception e){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found",e);
        }
        //DB에서 가져온 user의 password는 암호화된 상태가 아니므로 암호화
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return new MyUserDetail(user);
    }
}
