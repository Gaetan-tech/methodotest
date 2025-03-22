package com.example.project.dto;


import com.example.project.model.Client;

import java.time.LocalDateTime;

public class ReservationDTO {


    private String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "ReservationDTO{" +
                ", email='" + email + '\'' +
                '}';
    }
}
