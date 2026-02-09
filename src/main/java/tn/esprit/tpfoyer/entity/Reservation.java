package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    String idReservation;

    Date anneeUniversitaire;
    Boolean estValide;

    @ManyToMany (mappedBy = "reservations")
    private Set<Chambre> chambres = new HashSet<>();

    @ManyToMany
    private Set<Etudiant> etudiants = new HashSet<>();
}
