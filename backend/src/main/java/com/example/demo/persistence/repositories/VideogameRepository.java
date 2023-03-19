package com.example.demo.persistence.repositories;

import com.example.demo.domain.persistenceClasses.VideogamePersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<VideogamePersistence, Long> {
    boolean existsById(int id);
}
