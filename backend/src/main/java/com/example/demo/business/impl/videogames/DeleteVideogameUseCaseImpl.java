package com.example.demo.business.impl.videogames;

import com.example.demo.business.cases.videogames.DeleteVideogameUseCase;
import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteVideogameUseCaseImpl implements DeleteVideogameUseCase {
    private final VideogameRepository videogameRepository;

    @Override
    public Videogame DeleteVideogame(int id) {
        Optional<VideogamePersistence> vp = videogameRepository.findById(Long.valueOf(id));
        if(vp.isEmpty()) {

        }
        videogameRepository.deleteById(Long.valueOf(id));
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
