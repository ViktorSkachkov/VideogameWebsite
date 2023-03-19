package com.example.demo.business.impl.news;

import com.example.demo.domain.News;
import com.example.demo.domain.persistenceClasses.NewsPersistence;
import com.example.demo.persistence.repositories.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddNewsUseCaseImplTest {
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private AddNewsUseCaseImpl addNewsUseCase;

    @Test
    void AddNews() {
        News expectedResult = News.builder()
                .id(3)
                .image("name3")
                .title("title3")
                .text("text3")
                .gameId(1)
                .build();
        NewsPersistence news = NewsPersistence.builder()
                .image("name3")
                .title("title3")
                .text("text3")
                .game_id(1)
                .build();
        when(newsRepository.save(news))
                .thenReturn(news);
        News actualResult = addNewsUseCase.AddNews(expectedResult);
        assertEquals(expectedResult, actualResult);
        verify(newsRepository).save(news);
    }
}