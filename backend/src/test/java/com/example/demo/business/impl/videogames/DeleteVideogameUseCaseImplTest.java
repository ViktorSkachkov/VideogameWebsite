package com.example.demo.business.impl.videogames;

import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteVideogameUseCaseImplTest {
    @Mock
    private VideogameRepository videogameRepository;
    @InjectMocks
    private DeleteVideogameUseCaseImpl deleteVideogameUseCase;

    @Test
    void DeleteVideogame() {
        Videogame expectedResult = Videogame.builder()
                .id(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        VideogamePersistence videogame = VideogamePersistence.builder()
                .id(1L)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        when(videogameRepository.findById(1L))
                .thenReturn(Optional.ofNullable(videogame));
        Videogame actualResult = deleteVideogameUseCase.DeleteVideogame(1);
        assertEquals(expectedResult, actualResult);
        verify(videogameRepository).deleteById(Long.valueOf(1));
    }
}