package lt.codeacademy.carrental.repositories;

import lt.codeacademy.carrental.entities.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
