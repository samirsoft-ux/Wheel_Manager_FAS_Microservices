package pe.edu.upc.producto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.producto_service.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
