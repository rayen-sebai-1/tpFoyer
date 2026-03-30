package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;
    ReservationRepository reservationRepository;

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Chambre addChambreAndReservation(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void reserverChambre(String reservationId, Long chambreId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Chambre chambre = chambreRepository.findById(chambreId).get();

        reservation.setChambre(chambre);
        reservationRepository.save(reservation);
    }

    public void annulerReservation(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        reservation.setChambre(null);
        reservationRepository.save(reservation);
    }
}
