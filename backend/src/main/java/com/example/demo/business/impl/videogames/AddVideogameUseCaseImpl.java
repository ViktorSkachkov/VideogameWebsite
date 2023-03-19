package com.example.demo.business.impl.videogames;

import com.example.demo.business.cases.videogames.AddVideogameUseCase;
import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddVideogameUseCaseImpl implements AddVideogameUseCase {
    private final VideogameRepository videogameRepository;

    @Override
    public Videogame AddVideogame(Videogame videogame) {
        if(videogame.getDescription().length() <= 500) {
            VideogamePersistence vp = VideogamePersistence.builder()
                    .name(videogame.getName())
                    .price(videogame.getPrice())
                    .description(videogame.getDescription())
                    .featured(videogame.getFeatured())
                    .image(videogame.getImage())
                    .build();
            videogameRepository.save(vp);
        }
        else {

        }
        return videogame;
    }
}
