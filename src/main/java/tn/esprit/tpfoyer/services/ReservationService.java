package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private ReservationRepository reservationRepository;
    private ChambreRepository chambreRepository;
    private EtudiantRepository etudiantRepository;

    @Override
    public Reservation addOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }


    @Override
    public Reservation affecterReservationAChambre(String idReservation, Long idChambre) {
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

        if (reservation == null || chambre == null) return null;

        // IMPORTANT: owner side is Chambre (Reservation has mappedBy="reservations")
        chambre.getReservations().add(reservation);
        chambreRepository.save(chambre);

        // keep both sides consistent (optional but recommended)
        reservation.getChambres().add(chambre);

        return reservation;
    }


    @Override
    public Reservation affecterEtudiantAReservation(Long idEtudiant, String idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);

        if (reservation == null || etudiant == null) return null;

        // owner side is Reservation (no mappedBy)
        reservation.getEtudiants().add(etudiant);
        return reservationRepository.save(reservation);
    }
}
