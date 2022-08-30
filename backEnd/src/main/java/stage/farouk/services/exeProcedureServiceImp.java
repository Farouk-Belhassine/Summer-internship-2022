package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.*;
import stage.farouk.repository.exeProcedureRepository;
import stage.farouk.repository.procedureRepository;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class exeProcedureServiceImp implements exeIprocedureService{
    @Autowired
    exeProcedureRepository exeProcedureRepository;

    @Autowired
    procedureRepository procedureRepository;

    @Override
    public List<ExeProc> getAllProceduresNoSeq() {
        return (List<ExeProc>) exeProcedureRepository.getAllProceduresNoSeq();
    }

    @Override
    public ExeProc getProcedure(Long id) {
        return exeProcedureRepository.findById(id).get();
    }

    @Override
    @Transactional
    public ExeProc affectProcedureToExec(Long id, String comment) throws JAXBException, FileNotFoundException {
        Proc p = procedureRepository.findById(id).orElse(null);
        GenerateXml GenerateXml = new GenerateXml();
        GenerateXml.ToXml(p);

        ExeProc exeP = GenerateXml.FromXmlToExec(p.getName());
        exeP.setProcId(p.getId());
        exeP.setStartExecTime(Timestamp.from(Instant.now()));
        exeP.setComment(comment);

        exeProcedureRepository.save(exeP);
        return exeP;
    }
}
