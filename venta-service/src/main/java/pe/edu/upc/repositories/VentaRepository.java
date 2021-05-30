package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {

}
