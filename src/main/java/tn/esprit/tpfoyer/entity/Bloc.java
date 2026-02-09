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

public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private Set <Chambre> chambres = new HashSet<>();
}
