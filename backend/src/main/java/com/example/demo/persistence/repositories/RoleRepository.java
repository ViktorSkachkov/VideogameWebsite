package com.example.demo.persistence.repositories;

import com.example.demo.domain.persistenceClasses.RolePersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolePersistence, Long> {
    boolean existsById(int id);
}
