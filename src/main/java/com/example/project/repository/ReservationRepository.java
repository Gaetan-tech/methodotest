package com.example.project.repository;

import com.example.project.entity.ReservationEntity;
import com.example.project.model.Client;
import com.example.project.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ReservationRepository {
   Reservation createreservation(Reservation reservation);

   Optional<Reservation> getReservationById(int reservation_id);

   List<Reservation> getAllReservations();

}
