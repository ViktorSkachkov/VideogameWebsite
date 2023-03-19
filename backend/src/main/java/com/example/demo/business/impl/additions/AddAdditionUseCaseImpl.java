package com.example.demo.business.impl.additions;

import com.example.demo.business.cases.additions.AddAdditionUseCase;
import com.example.demo.domain.Addition;
import com.example.demo.domain.persistenceClasses.AdditionPersistence;
import com.example.demo.persistence.repositories.AdditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddAdditionUseCaseImpl implements AddAdditionUseCase {
    private final AdditionRepository additionRepository;

    @Override
    public Addition AddAddition(Addition addition) {
        if(addition.getDescription().length() <= 500) {
            AdditionPersistence ap = AdditionPersistence.builder()
                    .description(addition.getDescription())
                    .name(addition.getName())
                    .image(addition.getImage())
                    .game_id(addition.getGameId())
                    .price(addition.getPrice())
                    .build();
            additionRepository.save(ap);
        }
        else {

        }
        return addition;
    }
}
