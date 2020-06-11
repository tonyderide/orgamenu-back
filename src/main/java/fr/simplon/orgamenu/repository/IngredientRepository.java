package fr.simplon.orgamenu.repository;


import fr.simplon.orgamenu.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {


    @Query("select i from Ingredient i")
    List<Ingredient> findAll();

//    a refactoriser pour les boucles for
//    Select ingredient from co.users, co.calendrier, co.programmer, co.contenir, co.ingredient
//    where co.users.id=co.calendrier.user_id
//    and co.programmer.id_calendrier=co.calendrier.id_calendrier
//    and co.contenir.id_recette= co.programmer.id_recette
//    and co.contenir.id_ingredient=co.ingredient.id_ingredient
//    and co.users.id=2

//    @Query("select Ingredient from User, CalendrierRecette,  ")
//    List<Ingredient> find();
}
