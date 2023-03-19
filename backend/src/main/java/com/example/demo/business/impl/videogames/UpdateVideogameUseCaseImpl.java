package com.example.demo.business.impl.videogames;

import com.example.demo.business.cases.videogames.UpdateVideogameUseCase;
import com.example.demo.domain.Videogame;
import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import com.example.demo.persistence.repositories.VideogameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateVideogameUseCaseImpl implements UpdateVideogameUseCase {
    private final VideogameRepository videogameRepository;

    @Override
    public Videogame UpdateVideogame(Videogame videogame) {
        Optional<VideogamePersistence> vp = videogameRepository.findById(Long.valueOf(videogame.getId()));
        if(vp.isEmpty()) {

        }
        vp.get().setDescription(videogame.getDescription());
        vp.get().setFeatured(videogame.getFeatured());
        vp.get().setImage(videogame.getImage());
        vp.get().setName(videogame.getName());
        vp.get().setPrice(videogame.getPrice());
        videogameRepository.save(vp.get());
        return videogame;
    }
}
