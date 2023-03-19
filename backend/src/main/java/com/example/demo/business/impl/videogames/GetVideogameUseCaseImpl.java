package com.example.demo.business.impl.videogames;

import com.example.demo.business.cases.videogames.GetVideogameUseCase;
import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetVideogameUseCaseImpl implements GetVideogameUseCase {
    private final VideogameRepository videogameRepository;

    @Override
    public Videogame GetVideogame(int id) {
        Optional<VideogamePersistence> vp = videogameRepository.findById(Long.valueOf(id));
        if(vp.isEmpty()) {

        }
        Videogame videogame = Videogame.builder()
                .id(Math.toIntExact(vp.get().getId()))
                .featured(vp.get().getFeatured())
                .description(vp.get().getDescription())
                .image(vp.get().getImage())
                .name(vp.get().getName())
                .price(vp.get().getPrice())
                .build();
        return videogame;
    }
}
