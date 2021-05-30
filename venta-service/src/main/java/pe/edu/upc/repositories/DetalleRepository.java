package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle,Long> {

}
