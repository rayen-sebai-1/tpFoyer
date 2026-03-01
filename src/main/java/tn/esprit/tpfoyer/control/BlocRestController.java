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


}
