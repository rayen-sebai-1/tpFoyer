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
@ToString

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany (mappedBy = "foyer")
    private Set<Bloc> blocs = new HashSet<>();
}
