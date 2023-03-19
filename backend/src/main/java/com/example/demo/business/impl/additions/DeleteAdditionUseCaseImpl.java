package com.example.demo.business.impl.additions;

import com.example.demo.business.cases.additions.DeleteAdditionUseCase;
import com.example.demo.domain.Addition;
import com.example.demo.domain.persistenceClasses.AdditionPersistence;
import com.example.demo.persistence.repositories.AdditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteAdditionUseCaseImpl implements DeleteAdditionUseCase {
    private final AdditionRepository additionRepository;

    @Override
    public Addition DeleteAddition(int id) {
        Optional<AdditionPersistence> ap = additionRepository.findById(Long.valueOf(id));
        if(ap.isEmpty()) {

        }
        additionRepository.deleteById(Long.valueOf(id));
        Addition addition = Addition.builder()
                .id(Math.toIntExact(ap.get().getId()))
                .gameId(ap.get().getGame_id())
                .image(ap.get().getImage())
                .name(ap.get().getName())
                .description(ap.get().getDescription())
                .price(ap.get().getPrice())
                .build();
        return addition;
    }
}
