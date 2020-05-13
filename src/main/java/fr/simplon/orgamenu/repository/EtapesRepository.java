package fr.simplon.orgamenu.repository;

import fr.simplon.orgamenu.models.Etapes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapesRepository extends JpaRepository<Etapes, Long> {

}
