package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface IFoyerService {
    Foyer saveFoyer(Foyer foyer);

    void deleteFoyer(Long id);

    Foyer getFoyerById(Long id);

    Foyer updateFoyer(Foyer foyer);

    List<Foyer> getAllFoyer();

    Foyer addFoyerAndBloc(Foyer foyer);

    void assignBlocToFoyer(Long blocId, Long foyerId);

    void desaffecterBlocFromFoyer(Long blocId, Long foyerId);

    List<Foyer> findFoyersByTypeChambre(TypeChambre typeC);
}
