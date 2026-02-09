package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse;

    @OneToOne
    private Foyer foyer;
}
