package com.example.demo.business.cases.users;

import com.example.demo.domain.LoginResponse;
import com.example.demo.domain.User;

public interface UpdateUserUseCase {
    LoginResponse UpdateUser(User user);
}
