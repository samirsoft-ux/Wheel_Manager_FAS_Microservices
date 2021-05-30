package pe.edu.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.domain.model.Address;
import pe.edu.domain.model.User;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Page<Address> findByUserId(Long userId, Pageable pageable);
    Optional<Address> findByIdAndUserId(Long id, Long userId);

}
