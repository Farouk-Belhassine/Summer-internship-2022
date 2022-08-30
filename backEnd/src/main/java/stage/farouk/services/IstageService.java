package stage.farouk.services;

import stage.farouk.entity.Step;

public interface IstageService {
    void addNAffectStep(Long stageId);
    void deleteStep(Long stageId, Long stepId);
}