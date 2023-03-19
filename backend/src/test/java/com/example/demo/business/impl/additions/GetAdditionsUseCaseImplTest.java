package com.example.demo.business.impl.additions;

import com.example.demo.domain.Addition;
import com.example.demo.domain.persistenceClasses.AdditionPersistence;
import com.example.demo.persistence.repositories.AdditionRepository;
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
class GetAdditionsUseCaseImplTest {
    @Mock
    private AdditionRepository additionRepository;
    @InjectMocks
    private GetAdditionsUseCaseImpl getAdditionsUseCase;

    @Test
    void GetAdditions() {
        Addition addition1 = Addition.builder()
                .id(1)
                .gameId(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        Addition addition2 = Addition.builder()
                .id(2)
                .gameId(1)
                .name("name2")
                .price(10)
                .description("description2")
                .image("image2")
                .build();
        AdditionPersistence additionPersistence1 = AdditionPersistence.builder()
                .id(1L)
                .game_id(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        AdditionPersistence additionPersistence2 = AdditionPersistence.builder()
                .id(2L)
                .game_id(1)
                .name("name2")
                .price(10)
                .description("description2")
                .image("image2")
                .build();
        when(additionRepository.findAll())
                .thenReturn(List.of(additionPersistence1, additionPersistence2));
        List<Addition> actualResult = getAdditionsUseCase.GetAdditions();
        List<Addition> expectedResult = new ArrayList<>();
        expectedResult.add(addition1);
        expectedResult.add(addition2);
        assertEquals(expectedResult, actualResult);
        verify(additionRepository).findAll();
    }
}