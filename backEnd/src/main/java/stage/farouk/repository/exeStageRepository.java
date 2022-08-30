package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.ExeStage;

@Repository
public interface exeStageRepository extends CrudRepository<ExeStage, Long> {
}
