package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.ExeSequence;

@Repository
public interface exeSequenceRepository extends CrudRepository<ExeSequence, Long> {
}
