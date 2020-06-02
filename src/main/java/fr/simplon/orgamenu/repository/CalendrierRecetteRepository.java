package fr.simplon.orgamenu.repository;

import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;


@Repository
public interface CalendrierRecetteRepository extends JpaRepository<CalendrierRecette, Integer> {

    @Transactional
    @Modifying
    @Query("update CalendrierRecette c set c.date = :date WHERE c.idCalendrier = :idcalendrier")
    void updateById(@Param("idcalendrier") int idcalendrier, @Param("date") LocalDate date);

    @Query("select c from CalendrierRecette c where c.user.id= :id")
    Set<CalendrierRecette> findDateByIdUser(@Param("id") int id);

    @Query("select c from CalendrierRecette c where c.date = :date")
    Set<CalendrierRecette> findByDate(@Param("date") LocalDate date);

    @Query("select c from CalendrierRecette c where c.date = :date and c.user = :currentUser")
    Set<CalendrierRecette> findByDatebyCurrentUser(@Param("date") LocalDate date, User currentUser);


    void deleteByDate(LocalDate date);

    @Transactional
    @Modifying
//    @Query("DELETE FROM CalendrierRecette WHERE CalendrierRecette.date <= :date ")
//    void deleteinit(LocalDate date);
    void deleteByDateBefore(LocalDate date);

    @Transactional
    void deleteByDateAndUser(LocalDate date,User user);
}
