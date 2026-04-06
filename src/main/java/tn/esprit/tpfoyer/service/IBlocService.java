package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc saveOrUpdateBloc(Bloc bloc);

    void deleteBloc(Long id);

    Bloc findBlocById(Long id);

    List<Bloc> getAllBlocs();

    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(Long capaciteBloc);
    List<Bloc> findByNomBlocStartingWith(String nomBloc);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String nomBloc, Long capaciteBloc);
}
