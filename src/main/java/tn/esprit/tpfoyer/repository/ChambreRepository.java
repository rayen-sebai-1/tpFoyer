package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByTypeC(TypeChambre typeC);
    Chambre findByNumeroChambre(Long numeroChambre);

    @Query("SELECT c.typeC, COUNT(c) FROM Chambre c GROUP BY c.typeC")
    List<Object[]> countChambresByType();

          List<Chambre> findChambresByReservation(@Param("reservation") Reservation reservation);
}
