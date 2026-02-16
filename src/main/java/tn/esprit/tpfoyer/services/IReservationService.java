package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addOrUpdateReservation(Reservation reservation);
    void deleteReservation(String idReservation);
    List<Reservation> findAllReservations();
    Reservation findByReservation(String idReservation);


    Reservation affecterReservationAChambre(String idReservation, Long idChambre);


    Reservation affecterEtudiantAReservation(Long idEtudiant, String idReservation);
}
