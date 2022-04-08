package be.thomasmore.repositories;

import be.thomasmore.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {
    Optional<Department> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Department> findFirstByIdGreaterThanOrderById(int id);
    Optional<Department> findFirstByOrderByIdDesc();
    Optional<Department> findFirstByOrderByIdAsc();
}
