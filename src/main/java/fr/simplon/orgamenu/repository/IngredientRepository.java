package fr.simplon.orgamenu.repository;


import fr.simplon.orgamenu.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
//    SELECT * FROM ingredient JOIN recette on ingredient.id = recette.id JOIN calendrier ON recette.id = calendrier.id JOIN user ON calendrier.id = user.id

//    2020-06-13 04:47:49.451 ERROR 28753 --- [io-8080-exec-10] o.h.engine.jdbc.spi.SqlExceptionHelper   : Le nom de colonne id_ingredient n'a pas été trouvé dans ce ResultSet.
    @Query(value="SELECT * FROM co.ingredient\n" +
            "    JOIN co.contenir ON co.ingredient.id_ingredient = co.contenir.id_ingredient\n" +
            "    JOIN co.recette on co.contenir.id_recette = co.recette.id_recette\n" +
            "    join co.programmer on co.recette.id_recette = co.programmer.id_recette\n" +
            "    join co.calendrier on co.programmer.id_calendrier = co.calendrier.id_calendrier\n" +
            "    join co.users on co.calendrier.user_id = co.users.id\n" +
            "where username=?1",nativeQuery=true)
    List<Ingredient> find(String username);

//    @Query("SELECT i FROM  Ingredient i " +
//            "join Recette.ingredients ri ON Ingredient.idIngredient= ri.idIngredient " +
//            "where Recette.idRecette =1"
//            )
//List<Ingredient> find(String username);
}
