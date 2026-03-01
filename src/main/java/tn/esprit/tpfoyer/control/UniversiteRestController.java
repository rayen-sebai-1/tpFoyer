package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")


public class UniversiteRestController {
    IUniversiteService universiteService;
    @GetMapping("/get-all-universites")
    public List <Universite> getUniversites (){
        List<Universite> listUniversites = universiteService.getAllUniversites();
        return listUniversites;
    }


    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long unId) {
        Universite universite = universiteService.getUniversiteById(unId);
        return universite;
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.saveUniversite(u);
        return universite;
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.updateUniversite(u);
        return universite;
    }

    @DeleteMapping("/remove-universite/{universite-id}")

    public void removeUniversite(@PathVariable("universite-id") Long unId) {
        universiteService.deleteUniversite(unId);
    }


}
