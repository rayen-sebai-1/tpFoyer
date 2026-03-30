package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpfoyer.entity.Bloc;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToOne (mappedBy = "foyer")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private List<Bloc> blocs = new ArrayList<Bloc>();

}
