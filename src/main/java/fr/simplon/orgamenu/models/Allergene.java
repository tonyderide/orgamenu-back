package fr.simplon.orgamenu.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="allergene")
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAllergene;
    private String nomAllergene;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "concerner")
    private List<User> users = new ArrayList<>();


}
