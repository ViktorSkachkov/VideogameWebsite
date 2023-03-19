package com.example.demo.business.impl.news;

import com.example.demo.domain.News;
import com.example.demo.domain.persistenceClasses.NewsPersistence;
import com.example.demo.persistence.repositories.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateNewsUseCaseImplTest {
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private UpdateNewsUseCaseImpl updateNewsUseCase;

    @Test
    void UpdateNews() {
        News expectedResult = News.builder()
                .id(1)
                .image("name3")
                .title("title3")
                .text("text3")
                .gameId(1)
                .build();
        NewsPersistence news = NewsPersistence.builder()
                .id(1L)
                .image("name3")
                .title("title3")
                .text("text3")
                .game_id(1)
                .build();
        when(newsRepository.findById(1L))
                .thenReturn(Optional.ofNullable(news));
        newsRepository.findById(Long.valueOf(news.getId()));

        when(newsRepository.save(news))
                .thenReturn(news);
        News actualResult = updateNewsUseCase.UpdateNews(expectedResult);

        assertEquals(expectedResult, actualResult);
        verify(newsRepository).save(news);
    }
}