package com.example.demo.business.impl.news;

import com.example.demo.domain.News;
import com.example.demo.domain.persistenceClasses.NewsPersistence;
import com.example.demo.persistence.repositories.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetNewsUseCaseImplTest {
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private GetNewsUseCaseImpl getNewsUseCase;

    @Test
    void GetNews() {
        News news1 = News.builder()
                .id(1)
                .image("name1")
                .title("title1")
                .text("text1")
                .gameId(1)
                .build();
        NewsPersistence newsPersistence1 = NewsPersistence.builder()
                .id(1L)
                .image("name1")
                .title("title1")
                .text("text1")
                .game_id(1)
                .build();
        News news2 = News.builder()
                .id(2)
                .image("name2")
                .title("title2")
                .text("text2")
                .gameId(1)
                .build();
        NewsPersistence newsPersistence2 = NewsPersistence.builder()
                .id(2L)
                .image("name2")
                .title("title2")
                .text("text2")
                .game_id(1)
                .build();

        when(newsRepository.findAll())
                .thenReturn(List.of(newsPersistence1, newsPersistence2));
        List<News> actualResult = getNewsUseCase.GetNews();
        List<News> expectedResult = new ArrayList<>();
        expectedResult.add(news1);
        expectedResult.add(news2);
        assertEquals(expectedResult, actualResult);
        verify(newsRepository).findAll();
    }
}