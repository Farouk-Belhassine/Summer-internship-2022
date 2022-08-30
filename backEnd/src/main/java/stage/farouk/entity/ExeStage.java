package stage.farouk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Stage")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExeStage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    private int number;

    /*@ManyToOne
    ExeSequence ExeSequence;*/

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name="Step")
    private List<ExeStep> exeSteps;
}
