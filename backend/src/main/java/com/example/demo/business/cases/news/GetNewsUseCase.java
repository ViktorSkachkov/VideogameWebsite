package com.example.demo.business.cases.news;

import com.example.demo.domain.News;

import java.util.List;

public interface GetNewsUseCase {
    List<News> GetNews();
}
