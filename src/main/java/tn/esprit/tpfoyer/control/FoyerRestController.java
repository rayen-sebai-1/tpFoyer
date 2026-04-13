package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.service.IFoyerService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")


public class FoyerRestController {
    IFoyerService foyerService;
    @GetMapping("/get-all-foyers")
    public List <Foyer> getFoyers (){
        List<Foyer> listFoyers = foyerService.getAllFoyer();
        return listFoyers;
    }


    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foId) {
        Foyer foyer = foyerService.getFoyerById(foId);
        return foyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.saveFoyer(f);
        return foyer;
    }

    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.updateFoyer(f);
        return foyer;
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")

    public void removeFoyer(@PathVariable("foyer-id") Long foId) {
        foyerService.deleteFoyer(foId);
    }

    @PostMapping("/add-foyer-and-bloc")
    public Foyer addFoyerAndBloc(@RequestBody Foyer foyer) {
        return foyerService.addFoyerAndBloc(foyer);
    }

    @PutMapping("/assign-bloc-to-foyer/{bloc-id}/{foyer-id}")
    public void affecterBlocAFoyer(
            @PathVariable("bloc-id") Long blocId,
            @PathVariable("foyer-id") Long foyerId) {
        foyerService.assignBlocToFoyer(blocId, foyerId);
    }

    @PutMapping("/desaffecter-bloc-de-foyer/{bloc-id}/{foyer-id}")
    public void desaffecterBlocDeFoyer(
            @PathVariable("bloc-id") Long blocId,
            @PathVariable("foyer-id") Long foyerId) {
        foyerService.desaffecterBlocFromFoyer(blocId, foyerId);
    }

    @GetMapping("/foyers-par-type-chambre/{typeC}")
    public List<Foyer> findFoyersByTypeChambre(@PathVariable TypeChambre typeC) {
        return foyerService.findFoyersByTypeChambre(typeC);
    }

}
