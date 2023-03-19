package com.example.demo.business.cases.videogames;

import com.example.demo.domain.Videogame;

import java.util.List;

public interface GetVideogamesUseCase {
    List<Videogame> GetVideogames();
}
