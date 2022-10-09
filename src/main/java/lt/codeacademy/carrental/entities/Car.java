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
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int yearOfProduction;

    @Column
    private double price;

    @Column
    private String category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private CarDetails carDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Agreement> agreements;
}
