package stage.farouk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.Stage;

@Repository
public interface stageRepository extends CrudRepository<Stage, Long> {
}