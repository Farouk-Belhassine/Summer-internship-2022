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
@XmlRootElement(name="Procedure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proc{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @XmlElement
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("number")
    @XmlElement(name="Sequence")
    private List<Sequence> sequences;

    public Proc(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public int smallestAvailableNumber(){
        int smallestNumber=1;
        for(Sequence s : this.getSequences()){
            if(s.getNumber()==smallestNumber) smallestNumber+=1;
            else return smallestNumber;
        }
        return smallestNumber;
    }
}
