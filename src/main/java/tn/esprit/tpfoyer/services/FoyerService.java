package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {

    private FoyerRepository foyerRepository;
    private BlocRepository blocRepository;

    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findByFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public Foyer affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (foyer == null || bloc == null) return null;

        bloc.setFoyer(foyer);
        blocRepository.save(bloc);

        return foyer;
    }
}
