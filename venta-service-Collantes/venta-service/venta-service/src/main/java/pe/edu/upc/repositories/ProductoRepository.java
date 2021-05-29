package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
