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
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String companyName;

    @Column
    private String address;

    @Column
    private String phoneNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private List<Car> cars;
}
