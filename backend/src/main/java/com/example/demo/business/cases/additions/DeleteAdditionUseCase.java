package com.example.demo.business.cases.additions;

import com.example.demo.domain.Addition;

public interface DeleteAdditionUseCase {
    Addition DeleteAddition(int index);
}
