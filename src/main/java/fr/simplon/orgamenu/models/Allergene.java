package fr.simplon.orgamenu.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "allergene")
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "concerner",
            joinColumns = @JoinColumn(name = "allergene_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    @JsonIgnoreProperties("users")
    private List<User> users = new ArrayList<>();
}
