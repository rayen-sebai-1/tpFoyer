package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")


public class ChambreRestController {
    IChambreService chambreService;
    @GetMapping("/get-all-chambres")
    public List <Chambre> getChambres (){
        List<Chambre> listChambres = chambreService.getAllChambres();
        return listChambres;
    }


    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.getChambreById(chId);
        return chambre;
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.saveChambre(c);
        return chambre;
    }

    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")

    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.deleteChambre(chId);
    }


}
