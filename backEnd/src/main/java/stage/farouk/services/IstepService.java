package stage.farouk.services;

import stage.farouk.entity.ExeStep;
import stage.farouk.entity.Step;

public interface IstepService {
    Step addStep(Step s);
    Step getStep(Long id);
    Step updateStep(Step s);
    void deleteStep(Long id);
}
