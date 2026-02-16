package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    List<Chambre> findAllChambres();
    Chambre findByChambre(Long idChambre);


    Chambre affecterChambreABloc(Long idChambre, Long idBloc);
}
