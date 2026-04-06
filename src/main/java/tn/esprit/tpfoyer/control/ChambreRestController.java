package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;
import lombok.AllArgsConstructor;
import tn.esprit.tpfoyer.entity.TypeChambre;

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


    @PostMapping("/ajouter-chambre-et-reservation")
    public Chambre addChambreAndReservation(@RequestBody Chambre chambre) {
        return chambreService.addChambreAndReservation(chambre);
    }

    @PutMapping("/reserver-chambre/{reservation-id}/{chambre-id}")
    public void reserverChambre(
            @PathVariable("reservation-id") String reservationId,
            @PathVariable("chambre-id") Long chambreId) {
        chambreService.reserverChambre(reservationId, chambreId);
    }

    @PutMapping("/annuler-reservation/{reservation-id}")
    public void annulerReservation(
            @PathVariable("reservation-id") String reservationId) {
        chambreService.annulerReservation(reservationId);
    }

    @GetMapping("/chambres-par-type/{typeC}")
    public List<Chambre> getChambresParType(@PathVariable TypeChambre typeC) {
        return chambreService.findByTypeC(typeC);
    }

    @GetMapping("/chambre-par-numero/{numeroChambre}")
    public Chambre getChambreParNumero(@PathVariable Long numeroChambre) {
        return chambreService.findByNumeroChambre(numeroChambre);
    }

}
