package com.example.project.jpa;

import com.example.project.entity.ClientEntity;
import com.example.project.mapper.ClientMapper;
import com.example.project.model.Client;
import com.example.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public class JpaClientRepository implements ClientRepository {

    private final SpringDataJpaClientRepository springDataJpaClientRepository;

    @Autowired
    public JpaClientRepository(SpringDataJpaClientRepository springDataJpaClientRepository) {
        this.springDataJpaClientRepository = springDataJpaClientRepository;
    }

    @Override
    public Client createClient(Client client) {
        ClientEntity clientEntity = ClientMapper.toEntity(client);
        return ClientMapper.toDomain(springDataJpaClientRepository.save(clientEntity));
    }

    @Override
    public Optional<Client> getClientById(int clientId) {
        return springDataJpaClientRepository.findById(clientId).map(ClientMapper::toDomain);
    }

    @Override
    public Optional<Client> getClientByEmail(String email) {
      return Optional.of(ClientMapper.toDomain(springDataJpaClientRepository.getClientByEmail(email)));
    }

    @Override
    public Optional<Client> verifyClient(String email, String password) {
        return Optional.of(ClientMapper.toDomain(springDataJpaClientRepository.verifyClient(email, password)));
    }
}
