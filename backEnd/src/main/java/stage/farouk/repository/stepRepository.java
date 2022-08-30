package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.Step;

@Repository
public interface stepRepository extends CrudRepository<Step, Long> {
}
