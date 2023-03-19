package com.example.demo.business.cases.news;

import com.example.demo.domain.News;

public interface GetOneNewsUseCase {
    News GetOneNews(int index);
}
