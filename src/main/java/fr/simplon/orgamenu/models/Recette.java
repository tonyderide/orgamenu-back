package fr.simplon.orgamenu.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "recette")
public class Recette {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecette;
    private String name;
    private int calorie;
    private int tempPreparation;
    private int tempCuisson;
    private String imageUrl;


    @JoinTable(name = "preferer",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("recettes")
    private Set<User> users = new HashSet<>();

    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_recette")
    private List<Etapes> etapes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "programmer",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_calendrier"))
    @JsonIgnoreProperties(value={"recettes","user"})
    private Set<CalendrierRecette> calendriers = new HashSet<>();


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "contenir",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private List<Ingredient> ingredients = new ArrayList<>();

}
