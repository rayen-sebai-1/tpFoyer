package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdateFoyer(Foyer foyer);
    void deleteFoyer(Long idFoyer);
    List<Foyer> findAllFoyers();
    Foyer findByFoyer(Long idFoyer);


    Foyer affecterBlocAFoyer(Long idBloc, Long idFoyer);
}
