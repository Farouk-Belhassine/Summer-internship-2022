package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.farouk.entity.Sequence;
import stage.farouk.services.IsequenceService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sequence")
public class sequenceController {
    @Autowired
    IsequenceService IsequenceService;

    //http://localhost:8083/condorweb/sequence/addStage/1
    @PostMapping("/addStage/{id}")
    public void addNAffectStage(@PathVariable("id") Long sequenceId){ IsequenceService.addNAffectStage(sequenceId); }

    //http://localhost:8083/condorweb/sequence/deleteStage/1,1
    @DeleteMapping("/deleteStage/{sequenceId},{stageId}")
    @ResponseBody
    public void deleteStage(@PathVariable("sequenceId") Long sequenceId, @PathVariable("stageId") Long stageId) {
        IsequenceService.deleteStage(sequenceId,stageId);
    }
}