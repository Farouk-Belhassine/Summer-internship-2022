package stage.farouk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Procedure")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExeProc{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long procId;
    private Timestamp startExecTime;
    private String comment;

    @XmlElement
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("number")
    @XmlElement(name="Sequence")
    private List<ExeSequence> exeSequences;

    public ExeProc(long id, String name, Date startExecTime, String comment) {
        this.id = id;
        this.name = name;
        this.startExecTime = new Timestamp(startExecTime.getTime());
        this.comment = comment;
    }
}
