package com.example.project.repository;

import com.example.project.model.Client;

import java.util.Optional;

public interface ClientRepository {

    Client createClient(Client client);

    Optional<Client> getClientById(int clientId);
    Optional<Client> getClientByEmail(String email);

    Optional<Client> verifyClient(String email, String password);
}
