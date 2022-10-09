package lt.codeacademy.carrental.repositories;

import lt.codeacademy.carrental.entities.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsRepository extends JpaRepository<CarDetails, Long> {
}
