package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;

    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;

    @ManyToMany()
    private Set<Reservation> reservations = new HashSet<>();
}
