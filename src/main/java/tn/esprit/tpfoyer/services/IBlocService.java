package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addOrUpdateBloc(Bloc bloc);
    void deleteBloc(long idBloc);
    List <Bloc> findAllBlocs();
    Bloc findByBloc (long idBloc);
}
