package fr.simplon.orgamenu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;
    private int quantity;
    private String nomIngredient;
    private int allergene;
    private int Type;
//    private LocalDate peremption;
//    private int calorie;


    @ManyToMany
    @JoinTable(name = "contenir",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    @JsonIgnore
    private List<Recette> recettes = new ArrayList<>();
}
