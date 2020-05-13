package fr.simplon.orgamenu.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.validation.constraints.*;

 @Getter
 @Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    //
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

    private Set<String> role;

}
