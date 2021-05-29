package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
