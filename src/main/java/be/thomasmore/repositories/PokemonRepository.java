package be.thomasmore.repositories;

import be.thomasmore.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
}
