package tn.esprit.tpfoyer.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")


public class ReservationRestController {
    IReservationService reservationService;
    @GetMapping("/get-all-reservations")
    public List <Reservation> getReservations (){
        List<Reservation> listReservations = reservationService.getAllReservations();
        return listReservations;
    }


    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String resId) {
        Reservation reservation = reservationService.getReservationById(resId);
        return reservation;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.saveReservation(r);
        return reservation;
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.updateReservation(r);
        return reservation;
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")

    public void removeReservation(@PathVariable("reservation-id") String resId) {
        reservationService.deleteReservation(resId);
    }


}
