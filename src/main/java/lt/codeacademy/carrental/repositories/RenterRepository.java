package lt.codeacademy.carrental.repositories;

import lt.codeacademy.carrental.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Long> {
}
