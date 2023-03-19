package com.example.demo.business.impl.users;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.RolePersistence;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.RoleRepository;
import com.example.demo.persistence.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddUserUseCaseImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AddUserUseCaseImpl addUserUseCase;

    @Test
    void AddUser() {
        Set<Role> rolesSet = new HashSet<>();
        Role role = Role.builder()
                .id(1)
                .role("EMPLOYEE")
                .user_id(3)
                .build();
        rolesSet.add(role);
        User expectedResult = User.builder()
                .id(3)
                .username("username3")
                .email("email3")
                .bankAccount("bankAccount3")
                .userRoles(rolesSet)
                .build();

        Set<RolePersistence> rolePersistenceSet = new HashSet<>();
        RolePersistence rolePersistence = RolePersistence.builder()
                .role("EMPLOYEE")
                .user(3L)
                .build();
        rolePersistenceSet.add(rolePersistence);
        UserPersistence user = UserPersistence.builder()
                .username("username3")
                .email("email3")
                .bank_account("bankAccount3")
                .userRoles(rolePersistenceSet)
                .build();

        when(userRepository.save(user))
                .thenReturn(user);
        User actualResult = addUserUseCase.AddUser(expectedResult);
        assertEquals(expectedResult, actualResult);
        verify(userRepository).save(user);
    }
}