package fr.simplon.orgamenu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "preferencealiment")
public class PreferenceAliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreferenceAliment;
    private String nomPreferenceAliment;

    @ManyToMany
    @JoinTable(name = "fournir",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "preferencealiment_id"))
    @JsonIgnore
    private List<User> userList = new ArrayList<>();//TODO changer to users
}
