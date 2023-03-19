package com.example.demo.business.impl.users;

import com.example.demo.business.cases.users.AddUserUseCase;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.RolePersistence;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.RoleRepository;
import com.example.demo.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AddUserUseCaseImpl implements AddUserUseCase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User AddUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPwd());

        UserPersistence up = UserPersistence.builder()
                .bank_account(user.getBankAccount())
                .email(user.getEmail())
                .pwd(encodedPassword)
                .username(user.getUsername())
                .build();

        UserPersistence up2 = userRepository.save(up);
        for(Role role : user.getUserRoles()) {
            RolePersistence rp = RolePersistence.builder()
                    .role(role.getRole())
                    .user(up2.getId())
                    .build();
            roleRepository.save(rp);
        }
        return user;
    }
}
