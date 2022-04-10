package be.thomasmore.repositories;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NewsRepository extends CrudRepository<News, Integer> {
    Optional<News> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<News> findFirstByIdGreaterThanOrderById(int id);
    Optional<News> findFirstByOrderByIdDesc();
    Optional<News> findFirstByOrderByIdAsc();
    @Query("SELECT n FROM News n WHERE :nameandtext IS NULL OR LOWER(n.name) LIKE LOWER(CONCAT('%',:nameandtext,'%')) OR LOWER(n.text) LIKE LOWER(CONCAT('%',:nameandtext,'%')) ")
    List<News> findByNameAndText(@Param("nameandtext") String nameandtext);
}


