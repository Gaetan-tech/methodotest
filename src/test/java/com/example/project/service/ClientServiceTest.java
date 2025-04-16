package com.example.project.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.project.model.Client;
import com.example.project.repository.ClientRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.setClientId(1);
        client.setNom("John Doe");
        client.setEmail("john.doe@example.com");
        client.setPassword("password123");
    }

    @AfterEach
    void tearDown() {
        reset(clientRepository);
    }

    // ✅ Test création client
    @Test
    void testCreateClient() {
        when(clientRepository.createClient(any(Client.class))).thenReturn(client);

        Client createdClient = clientService.createClient(client);

        assertNotNull(createdClient);
        assertEquals("John Doe", createdClient.getNom());
        assertEquals("john.doe@example.com", createdClient.getEmail());
        verify(clientRepository, times(1)).createClient(client);
    }

    // ✅ Récupération client par ID - succès
    @Test
    void testGetClientById_Success() {
        when(clientRepository.getClientById(1)).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.getClientById(1);

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getNom());
        verify(clientRepository, times(1)).getClientById(1);
    }

    // ❌ Récupération client par ID - échec
    @Test
    void testGetClientById_NotFound() {
        when(clientRepository.getClientById(999)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clientService.getClientById(999);
        });

        assertEquals("Client not found", exception.getMessage());
        verify(clientRepository, times(1)).getClientById(999);
    }

    // ✅ Récupération client par email - succès
    @Test
    void testGetClientByEmail_Success() {
        when(clientRepository.getClientByEmail("john.doe@example.com")).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.getClientByEmail("john.doe@example.com");

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getNom());
        verify(clientRepository, times(1)).getClientByEmail("john.doe@example.com");
    }

    // Récupération client par email - échec
    @Test
    void testGetClientByEmail_NotFound() {
        when(clientRepository.getClientByEmail("unknown@example.com")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clientService.getClientByEmail("unknown@example.com");
        });

        assertEquals("Client not found", exception.getMessage());
        verify(clientRepository, times(1)).getClientByEmail("unknown@example.com");
    }

    //  Vérification client - succès
    @Test
    void testVerifyClient_Success() {
        when(clientRepository.verifyClient("john.doe@example.com", "password123")).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.verifyClient("john.doe@example.com", "password123");

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getNom());
        verify(clientRepository, times(1)).verifyClient("john.doe@example.com", "password123");
    }

    //  Vérification client - échec
    @Test
    void testVerifyClient_NotFound() {
        when(clientRepository.verifyClient("john.doe@example.com", "wrongpassword")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clientService.verifyClient("john.doe@example.com", "wrongpassword");
        });

        assertEquals("Client not found", exception.getMessage());
        verify(clientRepository, times(1)).verifyClient("john.doe@example.com", "wrongpassword");
    }
}
