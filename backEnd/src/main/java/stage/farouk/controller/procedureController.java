package stage.farouk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import stage.farouk.entity.Proc;
import stage.farouk.services.IprocedureService;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/procedure")
public class procedureController {
    @Autowired
    IprocedureService IprocedureService;

    //http://localhost:8083/2k22internship/procedure/getAllProcedures
    @GetMapping("/getAllProcedures")
    public List<Proc> getAllProcedures() {
        return IprocedureService.getAllProceduresNoSeq();
    }

    //http://localhost:8083/2k22internship/procedure/getProcedure/1
    @GetMapping("/getProcedure/{id}")
    public Proc getProcedure(@PathVariable("id") Long id) {
        return IprocedureService.getProcedure(id);
    }

    //http://localhost:8083/2k22internship/procedure/addProcedure
    @PostMapping("/addProcedure")
    @ResponseBody
    public Proc addProcedure(@RequestBody Proc p)
    {
        return IprocedureService.addProcedure(p);
    }

    //http://localhost:8083/2k22internship/procedure/updateProcedure
    @PutMapping("/updateProcedure")
    @ResponseBody
    public Proc updateProcedure(@RequestBody Proc p) {
        return IprocedureService.updateProcedure(p);
    }


    //http://localhost:8083/2k22internship/procedure/deleteProcedure/2
    @DeleteMapping("/deleteProcedure/{id}")
    @ResponseBody
    public void deleteProcedure(@PathVariable("id") Long id) {
        IprocedureService.deleteProcedure(id);
    }

    //http://localhost:8083/2k22internship/procedure/addSequence/1
    @PostMapping("/addSequence/{id}")
    public void addNAffectSequence(@PathVariable("id") Long procId){
        IprocedureService.addNAffectSequence(procId);
    }

    //http://localhost:8083/2k22internship/procedure/deleteSequence/1,1
    @DeleteMapping("/deleteSequence/{procId},{sequenceId}")
    @ResponseBody
    public void deleteSequence(@PathVariable("procId") Long procId, @PathVariable("sequenceId") Long sequenceId) {
        IprocedureService.deleteSequence(procId,sequenceId);
    }

    //http://localhost:8083/2k22internship/procedure/LoadProcedureFromXml
    @PostMapping("/LoadProcedureFromXml")
    @ResponseBody
    public Proc LoadProcedureFromXml(@RequestParam("file") MultipartFile Mfile) throws JAXBException, IOException {
        String fileName = Mfile.getOriginalFilename();

        InputStream initialStream = Mfile.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);
        File file = new File(""+fileName);

        OutputStream outStream = new FileOutputStream(file);
        outStream.write(buffer);

        return IprocedureService.LoadXml(file);
    }

    //http://localhost:8083/2k22internship/procedure/createXml
    @GetMapping("/createXml/{procId}")
    public Blob createXml(@PathVariable("procId") Long procId) throws JAXBException, IOException, SQLException {
        File file = IprocedureService.createXml(procId);
        byte[] arr = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        Blob blob = new SerialBlob(arr);
        return blob;
    }
}