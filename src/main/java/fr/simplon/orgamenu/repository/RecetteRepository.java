package fr.simplon.orgamenu.repository;

import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecetteRepository extends JpaRepository<Recette, Integer> {
    List<Recette> findRecetteByCalendriers(@Param("i") CalendrierRecette i);
}
