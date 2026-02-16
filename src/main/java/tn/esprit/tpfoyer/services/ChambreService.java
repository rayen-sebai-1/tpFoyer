package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;

    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> findAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findByChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public Chambre affecterChambreABloc(Long idChambre, Long idBloc) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (chambre == null || bloc == null) return null;

        chambre.setBloc(bloc);
        return chambreRepository.save(chambre);
    }
}
