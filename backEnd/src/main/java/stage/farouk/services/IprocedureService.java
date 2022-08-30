package stage.farouk.services;

import stage.farouk.entity.Proc;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public interface IprocedureService {
    List<Proc> getAllProceduresNoSeq();
    Proc getProcedure(Long id);
    Proc addProcedure(Proc p);
    Proc updateProcedure(Proc p);
    void deleteProcedure(Long id);
    void addNAffectSequence(Long id);
    void deleteSequence(Long procId, Long sequenceId);
    File createXml(Long procId) throws JAXBException;
    Proc LoadXml(File file) throws JAXBException;
}
