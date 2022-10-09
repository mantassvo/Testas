package lt.codeacademy.carrental.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String phoneNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "renter_id")
    private List<Agreement> agreements;
}
