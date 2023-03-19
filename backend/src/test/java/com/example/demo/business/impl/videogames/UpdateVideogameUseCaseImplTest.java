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
class UpdateVideogameUseCaseImplTest {
    @Mock
    private VideogameRepository videogameRepository;
    @InjectMocks
    private UpdateVideogameUseCaseImpl updateVideogameUseCase;

    @Test
    void UpdateVideogame() {
        Videogame expectedResult = Videogame.builder()
                .id(1)
                .name("name3")
                .price(15)
                .description("description3")
                .image("image3")
                .build();
        VideogamePersistence videogame = VideogamePersistence.builder()
                .id(1L)
                .name("name3")
                .price(15)
                .description("description3")
                .image("image3")
                .build();

        when(videogameRepository.findById(1L))
                .thenReturn(Optional.ofNullable(videogame));
        videogameRepository.findById(Long.valueOf(videogame.getId()));

        when(videogameRepository.save(videogame))
                .thenReturn(videogame);
        Videogame actualResult = updateVideogameUseCase.UpdateVideogame(expectedResult);

        assertEquals(expectedResult, actualResult);
        verify(videogameRepository).save(videogame);
    }
}