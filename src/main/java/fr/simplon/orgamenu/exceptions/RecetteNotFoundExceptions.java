package fr.simplon.orgamenu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = ("la recette n'existe pas"))
public class RecetteNotFoundExceptions extends Exception {

}

