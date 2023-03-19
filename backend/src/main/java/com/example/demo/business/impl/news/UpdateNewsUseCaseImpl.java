package com.example.demo.business.impl.news;

import com.example.demo.business.cases.news.UpdateNewsUseCase;
import com.example.demo.domain.News;
import com.example.demo.domain.persistenceClasses.NewsPersistence;
import com.example.demo.persistence.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateNewsUseCaseImpl implements UpdateNewsUseCase {
    private final NewsRepository newsRepository;
    @Override
    public News UpdateNews(News news) {
        Optional<NewsPersistence> np = newsRepository.findById(Long.valueOf(news.getId()));
        if(np.isEmpty()) {

        }
        np.get().setGame_id(news.getGameId());
        np.get().setText(news.getText());
        np.get().setImage(news.getImage());
        np.get().setTitle(news.getTitle());
        newsRepository.save(np.get());
        return news;
    }
}
