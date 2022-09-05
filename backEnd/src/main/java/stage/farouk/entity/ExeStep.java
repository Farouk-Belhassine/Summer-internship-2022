package stage.farouk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Step")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExeStep {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    private String description;

    @XmlElement
    private int number;

    @XmlElement
    private String comment;
}
