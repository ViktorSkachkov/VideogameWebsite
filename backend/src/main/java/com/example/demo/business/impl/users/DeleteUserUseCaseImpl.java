package com.example.demo.business.impl.users;

import com.example.demo.business.cases.users.DeleteUserUseCase;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.persistenceClasses.RolePersistence;
import com.example.demo.domain.persistenceClasses.UserPersistence;
import com.example.demo.persistence.repositories.RoleRepository;
import com.example.demo.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User DeleteUser(int id) {
        Optional<UserPersistence> up = userRepository.findById(Long.valueOf(id));
        if(up.isEmpty()) {

        }
        //userRepository.deleteById(Long.valueOf(id));
        User user = User.builder()
                .id(Math.toIntExact(up.get().getId()))
                .username(up.get().getUsername())
                .pwd(up.get().getPwd())
                .bankAccount(up.get().getBank_account())
                .email(up.get().getEmail())
                .build();

        Set<Role> userRoles = new HashSet<>();
        for(RolePersistence role : up.get().getUserRoles()) {
            roleRepository.deleteById(role.getId());
            Role newRole = Role.builder()
                    .id(Math.toIntExact(role.getId()))
                    .role(role.getRole())
                    .user_id(Math.toIntExact(role.getUser()))
                    .build();
            userRoles.add(newRole);
        }
        user.setUserRoles(userRoles);
        userRepository.deleteById(Long.valueOf(id));
        return user;
    }
}
