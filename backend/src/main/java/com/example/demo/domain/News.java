package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class News {
    private int id;
    private int gameId;
    private String title;
    private String text;
    private String image;
    //private LocalDateTime date;
}
