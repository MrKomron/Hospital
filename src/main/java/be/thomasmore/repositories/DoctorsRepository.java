package be.thomasmore.repositories;

import be.thomasmore.model.Doctors;
import org.springframework.data.repository.CrudRepository;

public interface DoctorsRepository extends CrudRepository<Doctors,Integer> {
}
