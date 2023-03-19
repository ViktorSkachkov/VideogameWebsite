package com.example.demo.domain;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Addition {
    private int id;
    private int gameId;
    private String name;
    private double price;
    private String description;
    private String image;
}
