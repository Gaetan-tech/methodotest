package com.example.project.mapper;

import com.example.project.entity.ClientEntity;
import com.example.project.model.Client;

public class ClientMapper {

    public static Client toDomain(ClientEntity clientEntity) {
        Client client = new Client();
        client.setClientId(clientEntity.getClientId());
        client.setEmail(clientEntity.getEmail());
        client.setNom(clientEntity.getNom());
        client.setPointsFidelite(clientEntity.getPointsFidelite());
        client.setPassword(clientEntity.getPassword());
        client.setTelephone(clientEntity.getTelephone());
        return client;
    }

    public static ClientEntity toEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        if(client.getClientId() != 0) {
            clientEntity.setClientId(client.getClientId());
        }
        clientEntity.setEmail(client.getEmail());
        clientEntity.setNom(client.getNom());
        clientEntity.setPointsFidelite(client.getPointsFidelite());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setTelephone(client.getTelephone());
        return clientEntity;
    }
}
