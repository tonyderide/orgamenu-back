package fr.simplon.orgamenu.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calendrier")
public class CalendrierRecette {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalendrier;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "programmer",
            joinColumns = @JoinColumn(name = "id_calendrier"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    @JsonIgnoreProperties(value = {"calendriers", "users"})
    private Set<Recette> recettes = new HashSet<Recette>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"calendriers"})
    private User user;


}
