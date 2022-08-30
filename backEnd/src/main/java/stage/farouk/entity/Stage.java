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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @XmlElement
    private int number;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name="Step")
    private List<Step> steps;

    public int smallestAvailableNumber(){
        int smallestNumber=1;
        for(Step s : this.getSteps()){
            if(s.getNumber()==smallestNumber) smallestNumber+=1;
            else return smallestNumber;
        }
        return smallestNumber;
    }
}
