package com.example.demo.business.impl.users;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.RolePersistence;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUsersUseCaseImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private GetUsersUseCaseImpl getUsersUseCase;

    @Test
    void GetUsers() {
        Set<Role> rolesSet = new HashSet<>();
        Role role = Role.builder()
                .id(1)
                .role("EMPLOYEE")
                .user_id(1)
                .build();
        rolesSet.add(role);
        User user1 = User.builder()
                .id(1)
                .username("username1")
                .pwd("password")
                .email("email1")
                .bankAccount("bankAccount1")
                .userRoles(rolesSet)
                .build();

        Set<Role> rolesSet2 = new HashSet<>();
        Role role2 = Role.builder()
                .id(2)
                .role("EMPLOYEE")
                .user_id(2)
                .build();
        rolesSet.add(role2);
        User user2 = User.builder()
                .id(2)
                .username("username2")
                .pwd("password")
                .email("email2")
                .bankAccount("bankAccount2")
                .userRoles(rolesSet2)
                .build();

        Set<RolePersistence> rolePersistenceSet = new HashSet<>();
        RolePersistence rolePersistence = RolePersistence.builder()
                .id(1L)
                .role("EMPLOYEE")
                .user(1L)
                .build();
        rolePersistenceSet.add(rolePersistence);
        UserPersistence userPersistence1 = UserPersistence.builder()
                .id(1L)
                .username("username1")
                .pwd("password")
                .email("email1")
                .bank_account("bankAccount1")
                .userRoles(rolePersistenceSet)
                .build();

        Set<RolePersistence> rolePersistenceSet2 = new HashSet<>();
        RolePersistence rolePersistence2 = RolePersistence.builder()
                .id(2L)
                .role("EMPLOYEE")
                .user(2L)
                .build();
        rolePersistenceSet.add(rolePersistence2);
        UserPersistence userPersistence2 = UserPersistence.builder()
                .id(2L)
                .username("username2")
                .pwd("password")
                .email("email2")
                .bank_account("bankAccount2")
                .userRoles(rolePersistenceSet2)
                .build();

        when(userRepository.findAll())
                .thenReturn(List.of(userPersistence1, userPersistence2));
        List<User> actualResult = getUsersUseCase.GetUsers();
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(user1);
        expectedResult.add(user2);
        assertEquals(expectedResult, actualResult);
        verify(userRepository).findAll();
    }
}