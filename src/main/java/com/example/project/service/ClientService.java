package com.example.project.service;

import com.example.project.model.Client;
import com.example.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.createClient(client);
    }

    public Optional<Client> getClientById(int clientId) {
        Optional<Client> client = clientRepository.getClientById(clientId);
        if (client.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return clientRepository.getClientById(clientId);
    }

    public Optional<Client> getClientByEmail(String email) {
        Optional<Client> client = clientRepository.getClientByEmail(email);
        if (client.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return client;
    }

    public Optional<Client> verifyClient(String email, String password) {
        Optional<Client> client = clientRepository.verifyClient(email, password);
        if (client.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return client;
    }
}
