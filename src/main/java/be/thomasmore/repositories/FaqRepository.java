package be.thomasmore.repositories;

import be.thomasmore.controllers.FaqController;
import be.thomasmore.model.Faq;
import be.thomasmore.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FaqRepository extends CrudRepository<Faq, Integer> {

    @Query("SELECT f FROM Faq f WHERE :word IS NULL OR LOWER(f.question) LIKE LOWER(CONCAT('%',:word,'%')) OR LOWER(f.answer) LIKE LOWER(CONCAT('%',:word,'%'))")
    List<Faq> findByKeyword(@Param("word") String word);

}
