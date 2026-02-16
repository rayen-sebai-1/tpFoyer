package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdateUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    List<Universite> findAllUniversites();
    Universite findByUniversite(Long idUniversite);

    Universite affecterFoyerAUniversite(Long idFoyer, Long idUniversite);
}
