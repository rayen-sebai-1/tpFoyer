package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

@EnableScheduling
@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocRepository;

    @Override
    public Bloc saveOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBlocById(Long id) {
        return blocRepository.findById(id).get();
    }


    @Scheduled(cron = "0 15,45 8 * * MON")
    public List<Bloc> findByFoyerIsNull() {
        return blocRepository.findByFoyerIsNull();
    }

    public List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc) {
        return blocRepository.findByCapaciteBlocGreaterThan(capaciteBloc);
    }

    public List<Bloc> findByNomBlocStartingWith(String nomBloc) {
        return blocRepository.findByNomBlocStartingWith(nomBloc);
    }

    public List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(
            String nomBloc, Long capaciteBloc) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(
                nomBloc, capaciteBloc);
    }

}
