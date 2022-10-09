package lt.codeacademy.carrental.repositories;

import lt.codeacademy.carrental.entities.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
}
