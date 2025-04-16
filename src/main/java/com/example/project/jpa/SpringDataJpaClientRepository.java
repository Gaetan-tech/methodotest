package com.example.project.jpa;

import com.example.project.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataJpaClientRepository extends JpaRepository<ClientEntity, Integer> {
    @Query("select c from ClientEntity c where c.email = :email")
   ClientEntity getClientByEmail(@Param("email") String email);

    @Query("select c from ClientEntity c where c.email = :email and c.password = :password")
    ClientEntity verifyClient(@Param("email") String email, @Param("password") String password );
}

