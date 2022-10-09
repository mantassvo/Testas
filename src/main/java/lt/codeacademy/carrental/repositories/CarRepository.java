package lt.codeacademy.carrental.repositories;

import lt.codeacademy.carrental.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
