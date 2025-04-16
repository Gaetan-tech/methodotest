package com.example.project.dto;


import com.example.project.model.Client;

import java.time.LocalDateTime;

public class ReservationDTO {


    private String email;
    private LocalDateTime dateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "email='" + email + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
