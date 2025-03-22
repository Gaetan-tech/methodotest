package com.example.project.mapper;

import com.example.project.dto.ReservationDTO;
import com.example.project.entity.ReservationEntity;
import com.example.project.model.Reservation;

public class ReservationMapper {

    public static Reservation toDomain(ReservationEntity reservationEntity) {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(reservationEntity.getReservationId());
        reservation.setDateTime(reservationEntity.getDateTime());
        reservation.setConfirmed(true);
        reservation.setClient(ClientMapper.toDomain(reservationEntity.getClientEntity()));
        return reservation;
    }


    public static ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity reservationEntity = new ReservationEntity();
        if(reservation.getReservation_id()!=0){;
        reservationEntity.setReservationId(reservation.getReservation_id());
    }
        reservationEntity.setDateTime(reservation.getDateTime());
        reservationEntity.setConfirmed(reservation.isConfirmed());
        reservationEntity.setReservationId(reservation.getReservation_id());
        reservationEntity.setClientEntity(ClientMapper.toEntity(reservation.getClient()));
        return reservationEntity;
}
}

