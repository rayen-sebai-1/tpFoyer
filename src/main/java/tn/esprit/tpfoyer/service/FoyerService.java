package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;


@EnableScheduling
@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{


    private static final Log log = LogFactory.getLog(FoyerService.class);
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Scheduled(cron = "0/15 * 8-11 * * MON-FRI")
    @Override
    public List<Foyer> getAllFoyer() {
        log.info("tache planifiée");
        return foyerRepository.findAll();
    }

    public Foyer addFoyerAndBloc(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void assignBlocToFoyer(Long blocId, Long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        Foyer foyer = foyerRepository.findById(foyerId).get();
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }


    public void desaffecterBlocFromFoyer(Long blocId, Long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        blocRepository.save(bloc);
    }

    public List<Foyer> findFoyersByTypeChambre(TypeChambre typeC) {
        return foyerRepository.findFoyersByTypeChambre(typeC);
    }
}
