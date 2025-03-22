package com.example.project.jpa;

import com.example.project.entity.ReservationEntity;
import com.example.project.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
