package com.example.project.service;

import com.example.project.model.Reservation;
import com.example.project.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock  // Crée un mock du repository (Mockito va simuler son comportement)
    private ReservationRepository reservationRepository;

    @InjectMocks  // Injecte le mock dans la classe à tester
    private ReservationService reservationService;

    private Reservation reservation1;
    private Reservation reservation2;

    @BeforeEach  // Avant chaque test, on initialise les objets nécessaires
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Création de deux objets Reservation pour les tests
        reservation1 = new Reservation(1, LocalDateTime.now(), true);
        reservation2 = new Reservation(2, LocalDateTime.now().plusDays(1), false);
    }

    @Test
    void createReservation_ShouldReturnCreatedReservation() {
        // Simulation du repository : lorsqu'on appelle createreservation, on retourne reservation1
        when(reservationRepository.createreservation(any())).thenReturn(reservation1);

        // Appel de la méthode à tester
        Reservation createdReservation = reservationService.createReservation(reservation1);

        // Vérifications
        assertNotNull(createdReservation, "La réservation créée ne doit pas être nulle");
        assertEquals(reservation1.getDateTime(), createdReservation.getDateTime(), "Les dates doivent être identiques");

        // Vérifier que la méthode createreservation du repository a été appelée une seule fois
        verify(reservationRepository, times(1)).createreservation(reservation1);
    }

    @Test
    void getReservationById_ShouldReturnReservation_WhenExists() {
        // Simuler un repository qui trouve une réservation avec l'ID 1
        when(reservationRepository.getReservationById(1)).thenReturn(Optional.of(reservation1));

        // Appel de la méthode à tester
        Optional<Reservation> foundReservation = reservationService.getReservationById(1);

        // Vérifications
        assertTrue(foundReservation.isPresent(), "La réservation doit être présente");
        assertEquals(reservation1.getDateTime(), foundReservation.get().getDateTime(), "Les dates doivent correspondre");

        // Vérifier que la méthode getReservationById du repository a bien été appelée une fois
        verify(reservationRepository, times(1)).getReservationById(1);
    }

    @Test
    void getReservationById_ShouldThrowException_WhenNotExists() {
        // Simuler un repository qui ne trouve pas la réservation
        when(reservationRepository.getReservationById(1)).thenReturn(Optional.empty());

        // Vérifier qu'une exception est bien levée lorsque la réservation est introuvable
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            reservationService.getReservationById(1);
        });

        // Vérifier le message d'erreur attendu
        assertEquals("Reservation not found", exception.getMessage(), "Le message d'exception doit être 'Reservation not found'");

        // Vérifier que la méthode getReservationById a bien été appelée une seule fois
        verify(reservationRepository, times(1)).getReservationById(1);
    }

    @Test
    void getAllReservations_ShouldReturnListOfReservations() {
        // Simuler le comportement du repository : on retourne une liste de réservations
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);
        when(reservationRepository.getAllReservations()).thenReturn(reservations);

        // Appel de la méthode à tester
        List<Reservation> retrievedReservations = reservationService.getAllReservations();

        // Vérifications
        assertNotNull(retrievedReservations, "La liste des réservations ne doit pas être nulle");
        assertEquals(2, retrievedReservations.size(), "La liste doit contenir exactement 2 réservations");

        // Vérifier que la méthode getAllReservations du repository a bien été appelée une seule fois
        verify(reservationRepository, times(1)).getAllReservations();
    }
}
