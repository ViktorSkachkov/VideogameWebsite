package com.example.demo.business.cases.news;

import com.example.demo.domain.News;

import java.util.List;

public interface GetNewsByGameUseCase {
    List<News> GetNewsByGame(int index);
}
