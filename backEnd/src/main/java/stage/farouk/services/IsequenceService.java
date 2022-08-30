package stage.farouk.services;

import stage.farouk.entity.Sequence;

public interface IsequenceService {
    void addNAffectStage(Long sequenceId);
    void deleteStage(Long sequenceId, Long stageId);
}
