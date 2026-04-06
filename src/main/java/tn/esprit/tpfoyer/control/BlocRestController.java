package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")


public class BlocRestController {
    IBlocService blocService;
    @GetMapping("/get-all-blocs")
    public List <Bloc> getBlocs (){
        List<Bloc> listBlocs = blocService.getAllBlocs();
        return listBlocs;
    }


    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blId) {
        Bloc bloc = blocService.findBlocById(blId);
        return bloc;
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.saveOrUpdateBloc(b);
        return bloc;
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.saveOrUpdateBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")

    public void removeBloc(@PathVariable("bloc-id") Long blId) {
        blocService.deleteBloc(blId);
    }


    @GetMapping("/blocs-sans-foyer")
    public List<Bloc> getBlocsSansFoyer() {
        return blocService.findByFoyerIsNull();
    }

    @GetMapping("/blocs-par-capacite/{capacite}")
    public List<Bloc> getBlocsParCapacite(@PathVariable Long capacite) {
        return blocService.findByCapaciteBlocGreaterThan(capacite);
    }

    @GetMapping("/blocs-par-nom/{nomBloc}")
    public List<Bloc> getBlocsParNom(@PathVariable String nomBloc) {
        return blocService.findByNomBlocStartingWith(nomBloc);
    }

    @GetMapping("/blocs-par-nom-et-capacite/{nomBloc}/{capacite}")
    public List<Bloc> getBlocsParNomEtCapacite(
            @PathVariable String nomBloc,
            @PathVariable Long capacite) {
        return blocService.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(
                nomBloc, capacite);
    }

}
