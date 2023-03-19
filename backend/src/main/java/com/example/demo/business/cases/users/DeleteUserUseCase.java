package com.example.demo.business.cases.users;

import com.example.demo.domain.User;

public interface DeleteUserUseCase {
    User DeleteUser(int index);
}
