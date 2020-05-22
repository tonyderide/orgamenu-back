package fr.simplon.orgamenu.repository;

import fr.simplon.orgamenu.models.PreferenceAliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferenceRepository extends JpaRepository<PreferenceAliment,Integer> {

}
