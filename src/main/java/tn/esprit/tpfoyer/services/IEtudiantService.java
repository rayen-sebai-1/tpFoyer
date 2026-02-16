package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long idEtudiant);
    List<Etudiant> findAllEtudiants();
    Etudiant findByEtudiant(Long idEtudiant);
}
