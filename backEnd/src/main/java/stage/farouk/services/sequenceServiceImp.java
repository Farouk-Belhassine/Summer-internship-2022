package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.Proc;
import stage.farouk.entity.Sequence;
import stage.farouk.entity.Stage;
import stage.farouk.repository.sequenceRepository;
import stage.farouk.repository.stageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class sequenceServiceImp implements IsequenceService{
    @Autowired
    sequenceRepository sequenceRepository;
    @Autowired
    stageRepository stageRepository;


    @Override
    @Transactional
    public void addNAffectStage(Long sequenceId) {
        Sequence se = sequenceRepository.findById(sequenceId).orElse(null);

        Stage st = new Stage();
        if(se.getStages().isEmpty()) st.setNumber(1);
        else st.setNumber(se.smallestAvailableNumber());
        stageRepository.save(st);

        List<Stage> ListSt = se.getStages();
        ListSt.add(st);
        se.setStages(ListSt);
        sequenceRepository.save(se);
    }

    @Override
    @Transactional
    public void deleteStage(Long sequenceId, Long stageId) {
        Sequence se = sequenceRepository.findById(sequenceId).orElse(null);
        List<Stage> ListSt = se.getStages();

        Stage st = stageRepository.findById(stageId).orElse(null);
        ListSt.remove(st);
        se.setStages(ListSt);

        sequenceRepository.save(se);
        stageRepository.delete(stageRepository.findById(stageId).get());
    }
}
