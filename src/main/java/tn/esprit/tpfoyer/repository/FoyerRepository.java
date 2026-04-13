package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;
@Repository

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    @Query("SELECT f FROM Foyer f JOIN f.blocs bloc JOIN bloc.chambre chambre WHERE chambre.typeC = :typeC")
    List<Foyer> findFoyersByTypeChambre(@Param("typeC") TypeChambre typeC);
}
