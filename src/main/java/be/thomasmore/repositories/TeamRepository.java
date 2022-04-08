package be.thomasmore.repositories;

import be.thomasmore.model.Doctors;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Doctors,Integer> {
    Optional<Doctors> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Doctors> findFirstByIdGreaterThanOrderById(int id);
    Optional<Doctors> findFirstByOrderByIdDesc();
    Optional<Doctors> findFirstByOrderByIdAsc();
}
