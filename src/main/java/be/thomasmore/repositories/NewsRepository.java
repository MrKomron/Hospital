package be.thomasmore.repositories;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NewsRepository extends CrudRepository<News, Integer> {
    Optional<News> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<News> findFirstByIdGreaterThanOrderById(int id);
    Optional<News> findFirstByOrderByIdDesc();
    Optional<News> findFirstByOrderByIdAsc();
}
