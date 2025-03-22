package com.example.project.jpa;

import com.example.project.entity.ClientEntity;
import com.example.project.entity.ReservationEntity;
import com.example.project.mapper.ClientMapper;
import com.example.project.mapper.ReservationMapper;
import com.example.project.model.Reservation;
import com.example.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaReservationRepository implements ReservationRepository {


    private final SpringDataJpaReservationRepository springDataJpaReservationRepository;

    @Autowired
    public JpaReservationRepository(SpringDataJpaReservationRepository springDataJpaReservationRepository) {
        this.springDataJpaReservationRepository= springDataJpaReservationRepository;
    }

    @Override
    public Reservation createreservation(Reservation reservation) {
        ReservationEntity reservationEntity = ReservationMapper.toEntity(reservation);
        return ReservationMapper.toDomain(springDataJpaReservationRepository.save(reservationEntity));
    }

    @Override
    public Optional<Reservation> getReservationById(int reservation_id) {
        return springDataJpaReservationRepository.findById(reservation_id).map(ReservationMapper::toDomain);
    }
}
