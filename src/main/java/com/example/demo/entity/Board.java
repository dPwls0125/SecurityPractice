package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="title")
    String title;

    @Column(name="content")
    String content;
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
