package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

@EnableScheduling
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

    public List<Chambre> findByTypeC(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    public Chambre findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Scheduled(cron = "0 0/10 9-17 * * TUE-FRI")
    public List<Object[]> countChambresByType() {
        return chambreRepository.countChambresByType();
    }

    public List<Chambre> findChambresByReservation(Reservation reservation) {
        return chambreRepository.findChambresByReservation(reservation);
    }
}
