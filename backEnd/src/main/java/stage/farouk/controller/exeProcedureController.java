package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import stage.farouk.entity.ExeProc;
import stage.farouk.entity.Proc;
import stage.farouk.services.exeIprocedureService;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/exeProcedure")
public class exeProcedureController {
    @Autowired
    exeIprocedureService IprocedureService;

    //http://localhost:8083/2k22internship/exeProcedure/getAllExeProcedures
    @GetMapping("/getAllExeProcedures")
    public List<ExeProc> getAllExeProcedures() {
        return IprocedureService.getAllProceduresNoSeq();
    }

    //http://localhost:8083/2k22internship/exeProcedure/getProcedure/1
    @GetMapping("/getProcedure/{id}")
    public ExeProc getProcedure(@PathVariable("id") Long id) {
        return IprocedureService.getProcedure(id);
    }

    //http://localhost:8083/2k22internship/exeProcedure/affectProcedureToExec/1
    @PostMapping("/affectProcedureToExec/{id}")
    public void affectProcedureToExec(@PathVariable("id") Long procId, @RequestParam("comment") String comment) throws JAXBException, FileNotFoundException { IprocedureService.affectProcedureToExec(procId,comment); }
}