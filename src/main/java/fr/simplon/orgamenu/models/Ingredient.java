package fr.simplon.orgamenu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    private String Type;
    private LocalDate peremption;
//    private int calorie;



    @ManyToMany
    @JoinTable(name = "contenir",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    @JsonIgnore
    private List<Recette> recettes = new ArrayList<>();
}
