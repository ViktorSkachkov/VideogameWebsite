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
class UpdateUserUseCaseImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UpdateUserUseCaseImpl updateUserUseCase;

    @Test
    void UpdateUser() {
        User expectedResult = User.builder()
                .id(1)
                .username("username3")
                .email("email3")
                .bankAccount("bankAccount3")
                //.role("role3")
                .build();
        UserPersistence user = UserPersistence.builder()
                .id(1L)
                .username("username3")
                .email("email3")
                .bank_account("bankAccount3")
                //.role("role3")
                .build();

        when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(user));
        userRepository.findById(Long.valueOf(user.getId()));

        when(userRepository.save(user))
                .thenReturn(user);
        User actualResult = updateUserUseCase.UpdateUser(expectedResult);

        assertEquals(expectedResult, actualResult);
        verify(userRepository).save(user);
    }
}