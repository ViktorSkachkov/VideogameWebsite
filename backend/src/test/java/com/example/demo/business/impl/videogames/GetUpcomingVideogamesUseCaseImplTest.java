package com.example.demo.business.impl.videogames;

import com.example.demo.persistence.repositories.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetUpcomingVideogamesUseCaseImplTest {
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private GetUpcomingVideogamesUseCaseImpl getUpcomingVideogamesUseCase;

    @Test
    void GetUpcomingVideogames() {

    }
}