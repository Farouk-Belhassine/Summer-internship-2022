package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.Sequence;

@Repository
public interface sequenceRepository extends CrudRepository<Sequence, Long> {
}
