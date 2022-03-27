package be.thomasmore.repositories;

import be.thomasmore.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ServicesRepository extends CrudRepository<Services,Integer> {

}
