package com.example.demo.business.cases;

import com.example.demo.domain.LoginRequest;
import com.example.demo.domain.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}