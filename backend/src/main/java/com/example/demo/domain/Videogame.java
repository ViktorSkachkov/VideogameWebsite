package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Videogame {
    private int id;
    private String name;
    private double price;
    private String description;
    private Boolean featured;
    private String image;
}
