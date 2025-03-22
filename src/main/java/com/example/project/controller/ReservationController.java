package com.example.project.controller;

import com.example.project.dto.ReservationDTO;
import com.example.project.entity.ReservationEntity;
import com.example.project.model.Client;
import com.example.project.model.Reservation;
import com.example.project.service.ClientService;
import com.example.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService service;
    private final ClientService clientService;



    @Autowired
    public ReservationController(ReservationService service, ClientService clientService) {
        this.service = service;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationDTO dto) {
        Client client = clientService.getClientByEmail(dto.getEmail()).get();
        Reservation reservation = new Reservation(client);
        return ResponseEntity.ok(service.createReservation(reservation));
    }

//    @GetMapping
//    public ResponseEntity<List<ReservationEntity>> getAll() {
//        return ResponseEntity.ok(service.getAllReservations());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
//
//        return ResponseEntity.ok(ReservationService.getReservationById(id).get());
//    }



}