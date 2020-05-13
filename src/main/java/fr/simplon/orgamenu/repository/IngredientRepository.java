//package fr.simplon.orgamenu.repository;
//
//import fr.simplon.orgamenu.models.CalendrierRecette;
//import fr.simplon.orgamenu.models.Ingredient;
//import fr.simplon.orgamenu.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.Optional;
//import java.util.Set;
//
//@Repository
//public interface IngredientRepository extends JpaRepository {
//
//
//    @Query("select i from Ingredient i where i.recettes = :date and c.user = :currentUser")
//    Set<CalendrierRecette> findIngredientsByUserID();
//}
