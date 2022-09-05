package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.farouk.entity.Step;
import stage.farouk.services.IstepService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/step")
public class stepController {
    @Autowired
    IstepService IstepService;

    //http://localhost:8083/2k22internship/step/getStep/1
    @GetMapping("/getStep/{id}")
    public Step getStep(@PathVariable("id") Long id) {
        return IstepService.getStep(id);
    }

    //http://localhost:8083/2k22internship/step/updateStep
    @PutMapping("/updateStep")
    @ResponseBody
    public Step updateStep(@RequestBody Step s) {
        return IstepService.updateStep(s);
    }
}