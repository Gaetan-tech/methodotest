package com.example.project.entity;

import com.example.project.model.Client;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;

    @JoinColumn(name = "clientid")
    @ManyToOne
    private ClientEntity clientEntity;

    @Column(name = "status")
    private boolean confirmed;

    @PrePersist
    public void onPersist(){
        this.dateTime = LocalDateTime.now();
    }

        public ReservationEntity() {}

    public ReservationEntity(ClientEntity clientEntity, boolean confirmed) {

        this.clientEntity = clientEntity;
        this.confirmed = true;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "reservationId=" + reservationId +
                ", dateTime=" + dateTime +
                ", clientEntity=" + clientEntity +
                ", confirmed=" + confirmed +
                '}';
    }
}
