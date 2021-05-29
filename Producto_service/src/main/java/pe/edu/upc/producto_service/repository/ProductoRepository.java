package pe.edu.upc.producto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.producto_service.entities.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //public List<Producto> findByCategory(Category category);
}
