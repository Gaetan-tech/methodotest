package com.example.project.jpa;

import com.example.project.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaClientRepository extends JpaRepository<ClientEntity, Integer> {
}
