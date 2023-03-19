package com.example.demo.business.cases.videogames;

import com.example.demo.domain.Videogame;

import java.util.List;

public interface GetFeaturedVideogamesUseCase {
    List<Videogame> GetFeaturedVideogames();
}
