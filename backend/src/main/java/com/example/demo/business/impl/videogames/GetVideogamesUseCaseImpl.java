package com.example.demo.business.impl.videogames;

import com.example.demo.business.cases.videogames.GetVideogamesUseCase;
import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetVideogamesUseCaseImpl implements GetVideogamesUseCase {
    private final VideogameRepository videogameRepository;

    @Override
    public List<Videogame> GetVideogames() {
        List<VideogamePersistence> list = videogameRepository.findAll();
        List<Videogame> videogames = new ArrayList<>();
        for(VideogamePersistence vp : list) {
            Videogame videogame = Videogame.builder()
                    .id(Math.toIntExact(vp.getId()))
                    .featured(vp.getFeatured())
                    .image(vp.getImage())
                    .description(vp.getDescription())
                    .price(vp.getPrice())
                    .name(vp.getName())
                    .build();
            videogames.add(videogame);
        }
        return videogames;
    }
}
