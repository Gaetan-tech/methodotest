package com.example.project.model;

import java.time.LocalDateTime;

public class Reservation {

    private int reservation_id;
    private Client client;
    private LocalDateTime dateTime;
    private boolean confirmed;

    public Reservation() {}

    public Reservation(int reservation_id, Client client, LocalDateTime dateTime, boolean confirmed) {
        this.reservation_id = reservation_id;
        this.client = client;
        this.dateTime = dateTime;
        this.confirmed = confirmed;
    }

    public Reservation(Client client) {
        this.client = client;
        this.confirmed = true;
    }


    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", client=" + client +
                ", dateTime=" + dateTime +
                ", confirmed=" + confirmed +
                '}';
    }
}


