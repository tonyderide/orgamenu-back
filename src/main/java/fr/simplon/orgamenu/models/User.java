package fr.simplon.orgamenu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    @JsonIgnore
    private String password;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotNull
    private int size;
    @NotNull
    private int weight;
    @NotNull
    private int age;
    @NotBlank
    private String sexe;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "preferer",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_recette"))
    @JsonIgnoreProperties({"users", "calendriers"})
    private Set<Recette> recettes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "fournir",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "preferencealiment_id"))
    @JsonIgnoreProperties("userList")
    private List<PreferenceAliment> preferenceAliments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"user", "recettes"})
    private Set<CalendrierRecette> calendriers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "concerner",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "allergene_id"))
    @JsonIgnoreProperties("users")
    private List<Allergene> allergenes = new ArrayList<>();

    public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password, @NotBlank String firstname, @NotBlank String lastname, @NotBlank int size, @NotBlank int weight, @NotBlank int age, @NotBlank String sexe) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.sexe = sexe;
    }


}

