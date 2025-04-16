package com.example.project.controller;

import com.example.project.dto.ClientDto;
import com.example.project.model.Client;
import com.example.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto.getNom(), clientDto.getTelephone(), clientDto.getEmail(), clientDto.getPassword());
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getClientById(id).get());
    }

    @GetMapping("{email}/{password}")
    public ResponseEntity<Client> getClientById(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(clientService.verifyClient(email, password).get());
    }
}
