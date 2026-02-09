package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long  cin;
    String ecole;
    Date dataNaissance;
    @ManyToMany (mappedBy = "etudiants")
    private Set<Reservation> reservations = new HashSet<>();
}
