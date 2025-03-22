package com.example.project.service;

import com.example.project.model.Reservation;
import com.example.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Crée une nouvelle réservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.createreservation(reservation);
    }

    // Récupère une réservation par son ID
    public Optional<Reservation> getReservationById(int reservationId) {
        Optional<Reservation> reservation = reservationRepository.getReservationById(reservationId);
        if (reservation.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }
        return reservation;
    }
}
