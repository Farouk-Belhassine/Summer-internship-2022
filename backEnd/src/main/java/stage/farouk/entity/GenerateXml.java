package stage.farouk.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GenerateXml {

    public File ToXml(Proc p) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Proc.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.encoding", "UTF-8");
        marshaller.setProperty("jaxb.formatted.output", true);
        String procedureNameXml = p.getName()+".xml";
        File file = new File(procedureNameXml);
        marshaller.marshal(p, file);
        return file;
    }

    public Proc FromXml(File file) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Proc.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Proc p= (Proc)unmarshaller.unmarshal(file);
        return p;
    }

    public ExeProc FromXmlToExec(String procName) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ExeProc.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ExeProc p = (ExeProc) unmarshaller.unmarshal(new FileReader(procName+".xml"));
        return p;
    }
}