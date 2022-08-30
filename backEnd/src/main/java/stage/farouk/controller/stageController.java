package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.farouk.entity.Proc;
import stage.farouk.entity.Stage;
import stage.farouk.entity.Step;
import stage.farouk.services.IstageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stage")
public class stageController {
    @Autowired
    IstageService IstageService;

    //http://localhost:8083/condorweb/stage/addStep/1
    @PostMapping("/addStep/{id}")
    public void addNAffectStep(@PathVariable("id") Long stageId){
        IstageService.addNAffectStep(stageId);
    }

    //http://localhost:8083/condorweb/stage/deleteStep/1,1
    @DeleteMapping("/deleteStep/{stageId},{stepId}")
    @ResponseBody
    public void deleteStep(@PathVariable("stageId") Long stageId, @PathVariable("stepId") Long stepId) {
        IstageService.deleteStep(stageId,stepId);
    }
}