package com.example.demo.business.cases.additions;

import com.example.demo.domain.Addition;

public interface GetAdditionUseCase {
    Addition GetAddition(int index);
}
