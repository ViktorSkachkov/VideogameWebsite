package com.example.demo.business.impl.users;

import com.example.demo.business.cases.users.GetUserUseCase;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.RolePersistence;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public User GetUser(int index) {

        Optional<UserPersistence> up = userRepository.findById(Long.valueOf(index));
        if(up.isEmpty()) {

        }
        //String decodedPassword = passwordEncoder.decode(up.get().getPwd());
        User user = User.builder()
                .id(Math.toIntExact(up.get().getId()))
                .username(up.get().getUsername())
                .pwd(up.get().getPwd())
                .bankAccount(up.get().getBank_account())
                .email(up.get().getEmail())
                .build();

        Set<Role> userRoles = new HashSet<>();
        for(RolePersistence role : up.get().getUserRoles()) {
            Role newRole = Role.builder()
                    .id(Math.toIntExact(role.getId()))
                    .role(role.getRole())
                    .user_id(Math.toIntExact(role.getUser()))
                    .build();
            userRoles.add(newRole);
        }
        user.setUserRoles(userRoles);
        return user;
    }
}
