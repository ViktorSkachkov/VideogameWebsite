package com.example.demo.business.cases.videogames;

import com.example.demo.domain.Videogame;

import java.util.List;

public interface GetUpcomingVideogamesUseCase {
    List<Videogame> GetUpcomingVideogames();
}
