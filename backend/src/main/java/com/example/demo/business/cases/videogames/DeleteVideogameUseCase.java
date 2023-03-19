package com.example.demo.business.cases.videogames;

import com.example.demo.domain.Videogame;

public interface DeleteVideogameUseCase {
    Videogame DeleteVideogame(int index);
}
