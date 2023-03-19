package com.example.demo.business.impl.additions;

import com.example.demo.domain.Addition;
import com.example.demo.domain.persistenceClasses.AdditionPersistence;
import com.example.demo.persistence.repositories.AdditionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAdditionUseCaseImplTest {
    @Mock
    private AdditionRepository additionRepository;
    @InjectMocks
    private AddAdditionUseCaseImpl addAdditionUseCase;

    @Test
    void AddAddition() {
        Addition expectedResult = Addition.builder()
                .id(1)
                .gameId(1)
                .name("name3")
                .price(10)
                .description("description3")
                .image("image3")
                .build();
        AdditionPersistence addition = AdditionPersistence.builder()
                .game_id(1)
                .name("name3")
                .price(10)
                .description("description3")
                .image("image3")
                .build();
        when(additionRepository.save(addition))
                .thenReturn(addition);
        Addition actualResult = addAdditionUseCase.AddAddition(expectedResult);
        assertEquals(expectedResult, actualResult);
        verify(additionRepository).save(addition);
    }
}