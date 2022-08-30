package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.ExeStep;
import stage.farouk.entity.Step;
import stage.farouk.repository.stepRepository;

@Service
public class stepServiceImp implements IstepService{
    @Autowired
    stepRepository stepRepository;

    @Override
    public Step addStep(Step s) {
        stepRepository.save(s);
        return s;
    }

    @Override
    public Step getStep(Long id) {
        Step s = stepRepository.findById(id).get();
        return s;
    }

    @Override
    public Step updateStep(Step s) { return stepRepository.save(s); }

    @Override
    public void deleteStep(Long id) {
        stepRepository.delete(stepRepository.findById(id).get());
    }
}