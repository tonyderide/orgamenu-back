package fr.simplon.orgamenu.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="recette")
public class Recette {

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    private Set<User> users = new HashSet<User>();

    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "etapes_fk")
    private List<Etapes> etapes = new ArrayList<Etapes>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name= "programmer",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_calendrier"))
    @JsonIgnoreProperties({"recette"})
    private Set<CalendrierRecette> calendriers = new HashSet<CalendrierRecette>();


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "contenir",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

}
