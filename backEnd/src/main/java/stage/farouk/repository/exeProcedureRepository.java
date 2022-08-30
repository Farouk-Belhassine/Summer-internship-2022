package stage.farouk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stage.farouk.entity.ExeProc;

import java.util.List;

@Repository
public interface exeProcedureRepository extends CrudRepository<ExeProc, Long> {
    @Query("SELECT new ExeProc(p.id, p.name, p.startExecTime, p.comment) FROM ExeProc p")
    List<ExeProc> getAllProceduresNoSeq();
}
