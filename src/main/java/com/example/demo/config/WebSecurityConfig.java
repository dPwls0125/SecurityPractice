package com.example.demo.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{
    private static final String[] AUTH_WHITELIST = {
            // swagger
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/swagger-ui.html",

            "/v2/api-docs",
            "/webjars/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .requestMatchers(HttpMethod.POST,"/board/create/list").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/board/delete/{id}").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/board/update/list").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/board/get/list").hasRole("USER") // prefixed with ROLE_
                        .anyRequest().authenticated())

                .formLogin((form) -> form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
