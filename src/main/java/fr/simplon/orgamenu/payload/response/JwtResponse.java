package fr.simplon.orgamenu.payload.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private int id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private int size;
    private int weight;
    private int age;
    private String sexe;
    private List<String> roles;

    //constructeur sans le password
    public JwtResponse(String accessToken, int id, String username, String email, String firstname, String lastname, int size, int weight, int age, String sexe, List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.sexe = sexe;
        this.roles = roles;
    }
}
