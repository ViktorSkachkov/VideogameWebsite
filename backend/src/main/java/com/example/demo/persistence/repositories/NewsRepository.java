package com.example.demo.persistence.repositories;

import com.example.demo.domain.persistenceClasses.NewsPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsPersistence, Long> {
    boolean existsById(int id);
}
