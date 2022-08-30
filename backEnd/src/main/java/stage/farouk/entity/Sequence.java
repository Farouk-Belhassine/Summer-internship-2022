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
public class Sequence {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @XmlElement
    private int number;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("number")
    @XmlElement(name="Stage")
    private List<Stage> stages;

    public int smallestAvailableNumber(){
        int smallestNumber=1;
        for(Stage s : this.getStages()){
            if(s.getNumber()==smallestNumber) smallestNumber+=1;
            else return smallestNumber;
        }
        return smallestNumber;
    }
}
