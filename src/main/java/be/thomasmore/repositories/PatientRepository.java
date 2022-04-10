package be.thomasmore.repositories;

import be.thomasmore.model.Patient;
import be.thomasmore.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    Optional<Patient> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Patient> findFirstByIdGreaterThanOrderById(int id);
    Optional<Patient> findFirstByOrderByIdDesc();
    Optional<Patient> findFirstByOrderByIdAsc();

    @Query("SELECT p FROM Patient p " +
            "WHERE (:fname IS NULL OR  LOWER(p.firstname) LIKE LOWER(CONCAT('%',:fname,'%')))" +
            "AND (:lname IS NULL OR LOWER(p.lastname) LIKE LOWER(CONCAT('%',:lname,'%'))) "+
            "AND (:newClinet IS NULL OR p.isNewClient = :newClinet) " +
            "AND (:number IS NULL OR  LOWER(p.phoneNumber) LIKE LOWER(CONCAT('%',:number,'%'))) ")
    List<Patient> findByCapacityDistanceFoodIndoorOutdoor(
            @Param("fname") String fname,
            @Param("lname") String lname,
            @Param("newClinet") Boolean newClinet,
            @Param("number") Integer number);

}
