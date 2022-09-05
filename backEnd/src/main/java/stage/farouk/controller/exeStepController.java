package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.farouk.entity.ExeStep;
import stage.farouk.services.exeIstepService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/exeStep")
public class exeStepController {
    @Autowired
    exeIstepService exeIstepService;

    //http://localhost:8083/2k22internship/exeStep/getExeStep/1
    @GetMapping("/getExeStep/{id}")
    public ExeStep getStep(@PathVariable("id") Long id) {
        return exeIstepService.getStep(id);
    }

    //http://localhost:8083/2k22internship/exeStep/updateExeStep
    @PutMapping("/updateExeStep")
    @ResponseBody
    public ExeStep updateStep(@RequestBody ExeStep s) {
        return exeIstepService.updateStep(s);
    }
}