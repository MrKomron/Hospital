package be.thomasmore.repositories;

import be.thomasmore.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicesRepository extends CrudRepository<Services,Integer> {
    Optional<Services> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Services> findFirstByIdGreaterThanOrderById(int id);
    Optional<Services> findFirstByOrderByIdDesc();
    Optional<Services> findFirstByOrderByIdAsc();

    @Query("SELECT s FROM Services s WHERE :word IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(s.procInformation) LIKE LOWER(CONCAT('%',:word,'%')) " +
            "OR LOWER(s.canInformation) LIKE LOWER(CONCAT('%',:word,'%'))")
    List<Services> findByKeyword(@Param("word") String word);

}
