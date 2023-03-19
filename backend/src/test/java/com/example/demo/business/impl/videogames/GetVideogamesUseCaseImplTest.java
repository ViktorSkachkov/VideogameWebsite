package com.example.demo.business.impl.videogames;

import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetVideogamesUseCaseImplTest {
    @Mock
    private VideogameRepository videogameRepository;
    @InjectMocks
    private GetVideogamesUseCaseImpl getVideogamesUseCase;

    @Test
    void GetVideogames() {
       Videogame videogame1 = Videogame.builder()
                .id(1)
                .name("name1")
                .price(10)
                .featured(true)
                .description("description1")
                .image("image1")
                .build();
       Videogame videogame2 = Videogame.builder()
                .id(2)
                .name("name2")
                .price(10)
                .featured(true)
                .description("description2")
                .image("image2")
                .build();
        VideogamePersistence videogamePersistence1 = VideogamePersistence.builder()
                .id(1L)
                .name("name1")
                .price(10)
                .featured(true)
                .description("description1")
                .image("image1")
                .build();
        VideogamePersistence videogamePersistence2 = VideogamePersistence.builder()
                .id(2L)
                .name("name2")
                .price(10)
                .featured(true)
                .description("description2")
                .image("image2")
                .build();
        when(videogameRepository.findAll())
                .thenReturn(List.of(videogamePersistence1, videogamePersistence2));
        List<Videogame> actualResult = getVideogamesUseCase.GetVideogames();
        List<Videogame> expectedResult = new ArrayList<>();
        expectedResult.add(videogame1);
        expectedResult.add(videogame2);
        assertEquals(expectedResult, actualResult);
        verify(videogameRepository).findAll();
    }
}