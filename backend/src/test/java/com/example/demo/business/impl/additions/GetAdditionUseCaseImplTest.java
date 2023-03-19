package com.example.demo.business.impl.additions;

import com.example.demo.domain.Addition;
import com.example.demo.domain.persistenceClasses.AdditionPersistence;
import com.example.demo.persistence.repositories.AdditionRepository;
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
class GetAdditionUseCaseImplTest {
    @Mock
    private AdditionRepository additionRepository;
    @InjectMocks
    private GetAdditionUseCaseImpl getAdditionUseCase;

    @Test
    void GetAddition() {
        Addition expectedResult = Addition.builder()
                .id(1)
                .gameId(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        AdditionPersistence addition = AdditionPersistence.builder()
                .id(1L)
                .game_id(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        when(additionRepository.findById(1L))
                .thenReturn(Optional.ofNullable(addition));
        Addition actualResult = getAdditionUseCase.GetAddition(1);
        assertEquals(expectedResult, actualResult);
        verify(additionRepository).findById(1L);
    }
}