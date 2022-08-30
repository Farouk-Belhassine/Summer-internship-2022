package stage.farouk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @XmlElement
    private String description;

    @XmlElement
    private int number;

    @XmlElement
    private String comment;
}
