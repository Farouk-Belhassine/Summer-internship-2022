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
@XmlRootElement(name = "Sequence")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExeSequence {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    private int number;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("number")
    @XmlElement(name="Stage")
    private List<ExeStage> exeStages;
}
