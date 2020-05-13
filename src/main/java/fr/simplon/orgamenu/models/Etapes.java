package fr.simplon.orgamenu.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "etapes")
public class Etapes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEtape;
    private int numero;
    private String etape;

}
