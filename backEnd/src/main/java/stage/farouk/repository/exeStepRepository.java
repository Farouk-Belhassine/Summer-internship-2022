package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.ExeStep;

@Repository
public interface exeStepRepository extends CrudRepository<ExeStep, Long> {
}