package stage.farouk.services;

import stage.farouk.entity.ExeStep;

public interface exeIstepService {
    ExeStep getStep(Long id);
    ExeStep updateStep(ExeStep s);
}
