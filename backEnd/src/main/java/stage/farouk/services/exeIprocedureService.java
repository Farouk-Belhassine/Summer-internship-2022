package stage.farouk.services;

import stage.farouk.entity.ExeProc;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface exeIprocedureService {
    List<ExeProc> getAllProceduresNoSeq();
    ExeProc getProcedure(Long id);
    public ExeProc affectProcedureToExec(Long id, String comment) throws JAXBException, FileNotFoundException;
}