package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.Stage;
import stage.farouk.entity.Step;
import stage.farouk.repository.stageRepository;
import stage.farouk.repository.stepRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class stageServiceImp implements IstageService{
    @Autowired
    stageRepository stageRepository;
    @Autowired
    stepRepository stepRepository;


    @Override
    @Transactional
    public void addNAffectStep(Long stageId) {
        Stage stage = stageRepository.findById(stageId).orElse(null);

        Step step = new Step();
        if(stage.getSteps().isEmpty()) step.setNumber(1);
        else step.setNumber(stage.smallestAvailableNumber());
        stepRepository.save(step);

        List<Step> ListStep = stage.getSteps();
        ListStep.add(step);
        stage.setSteps(ListStep);
        stageRepository.save(stage);
    }

    @Override
    @Transactional
    public void deleteStep(Long stageId, Long stepId) {
        Stage stage = stageRepository.findById(stageId).orElse(null);
        List<Step> ListStep = stage.getSteps();

        Step step = stepRepository.findById(stepId).orElse(null);
        ListStep.remove(step);
        stage.setSteps(ListStep);

        stageRepository.save(stage);
        stepRepository.delete(stepRepository.findById(stepId).get());
    }
}
