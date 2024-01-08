package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "email")
    private String email;
    @Column(nullable = false,name = "password")
    private String password;
    @Column(nullable = true, name = "role")
    private String role;
}
