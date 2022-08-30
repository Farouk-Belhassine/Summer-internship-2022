package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.ExeStep;
import stage.farouk.repository.exeStepRepository;

@Service
public class exeStepServiceImp implements exeIstepService{
    @Autowired
    exeStepRepository exeStepRepository;

    @Override
    public ExeStep getStep(Long id) {
        ExeStep s = exeStepRepository.findById(id).get();
        return s;
    }

    @Override
    public ExeStep updateStep(ExeStep s) { return exeStepRepository.save(s); }
}
