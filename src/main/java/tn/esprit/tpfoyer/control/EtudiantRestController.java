package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")


public class EtudiantRestController {
    IEtudiantService etudiantService;
    @GetMapping("/get-all-etudiants")
    public List <Etudiant> getEtudiants (){
        List<Etudiant> listEtudiants = etudiantService.getAllEtudiants();
        return listEtudiants;
    }


    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etId) {
        Etudiant etudiant = etudiantService.getEtudiantById(etId);
        return etudiant;
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.saveEtudiant(e);
        return etudiant;
    }

    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")

    public void removeEtudiant(@PathVariable("etudiant-id") Long etId) {
        etudiantService.deleteEtudiant(etId);
    }


}
