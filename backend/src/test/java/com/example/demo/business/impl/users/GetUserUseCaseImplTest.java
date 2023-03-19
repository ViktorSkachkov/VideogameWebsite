package com.example.demo.business.impl.users;

import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserUseCaseImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private GetUserUseCaseImpl getUserUseCase;

    @Test
    void GetUser() {
        User expectedResult = User.builder()
                .id(1)
                .username("username1")
                .email("email1")
                .bankAccount("bankAccount1")
                //.role("role1")
                .build();
        UserPersistence user = UserPersistence.builder()
                .id(1L)
                .username("username1")
                .email("email1")
                .bank_account("bankAccount1")
                //.role("role1")
                .build();
        when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(user));
        User actualResult = getUserUseCase.GetUser(1);
        assertEquals(expectedResult, actualResult);
        verify(userRepository).findById(1L);
    }
}