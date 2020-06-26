package fr.simplon.orgamenu.models;

import lombok.*;

import javax.persistence.*;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtape;
    private int numero;
    private String etape;

}
