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

@Table(name="preferencealiment")
public class PreferenceAliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreferenceAliment;
    private String nomPreferenceAliment;

    @ManyToMany
    @JoinTable(name= "fournir",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "preferencealiment_id"))
    private List<User> userList = new ArrayList<>();//TODO changer to users
}
