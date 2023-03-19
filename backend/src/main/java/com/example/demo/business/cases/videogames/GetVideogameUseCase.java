package com.example.demo.business.cases.videogames;

import com.example.demo.domain.Videogame;

public interface GetVideogameUseCase {
    Videogame GetVideogame(int index);
}
