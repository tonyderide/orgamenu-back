package fr.simplon.orgamenu.repository;

import fr.simplon.orgamenu.models.Allergene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergeneRepository extends JpaRepository<Allergene, Integer> {

    List<Allergene> findAllByUsers_id(int id);
}
