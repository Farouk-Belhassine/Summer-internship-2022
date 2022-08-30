package stage.farouk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.farouk.entity.*;
import stage.farouk.repository.procedureRepository;
import stage.farouk.repository.sequenceRepository;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import java.io.File;
import java.util.List;

@Service
public class procedureServiceImp implements IprocedureService{
    @Autowired
    procedureRepository procedureRepository;
    @Autowired
    sequenceRepository sequenceRepository;

    @Override
    public List<Proc> getAllProceduresNoSeq() {
        return (List<Proc>) procedureRepository.getAllProceduresNoSeq();
    }

    @Override
    public Proc getProcedure(Long id) {
        return procedureRepository.findById(id).get();
    }

    @Override
    public Proc addProcedure(Proc p) {
        procedureRepository.save(p);
        return p;
    }

    @Override
    public Proc updateProcedure(Proc p) {
        return procedureRepository.save(p);
    }

    @Override
    public void deleteProcedure(Long id) {
        procedureRepository.delete(procedureRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void addNAffectSequence(Long procId) {
        Proc p = procedureRepository.findById(procId).orElse(null);

        Sequence s = new Sequence();
        if(p.getSequences().isEmpty()) s.setNumber(1);
        else s.setNumber(p.smallestAvailableNumber());
        sequenceRepository.save(s);

        List<Sequence> ListS = p.getSequences();
        ListS.add(s);
        p.setSequences(ListS);
        procedureRepository.save(p);
    }

    @Override
    @Transactional
    public void deleteSequence(Long procId, Long sequenceId) {
        Proc p = procedureRepository.findById(procId).orElse(null);


        List<Sequence> ListS = p.getSequences();
        Sequence s = sequenceRepository.findById(sequenceId).orElse(null);
        ListS.remove(s);
        p.setSequences(ListS);

        procedureRepository.save(p);
        sequenceRepository.delete(sequenceRepository.findById(sequenceId).get());
    }

    @Override
    public File createXml(Long procId) throws JAXBException {
        Proc p = procedureRepository.findById(procId).orElse(null);
        GenerateXml GenerateXml = new GenerateXml();
        File file = GenerateXml.ToXml(p);
        return file;
    }

    @Override
    @Transactional
    public Proc LoadXml(File file) throws JAXBException {
        GenerateXml GenerateXml = new GenerateXml();
        Proc p = GenerateXml.FromXml(file);
        procedureRepository.save(p);
        return p;
    }
}