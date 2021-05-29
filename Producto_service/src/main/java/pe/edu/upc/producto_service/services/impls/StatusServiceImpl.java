package pe.edu.upc.producto_service.services.impls;

import pe.edu.upc.producto_service.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StatusServiceImpl {

    Page<Status> getAllStatuses(Pageable pageable);
    Status getStatusById(Long statusId);
    Status createStatus(Status statusId);
    Status updateStatus(Long statusId, Status messageRequest);
    ResponseEntity<?> deleteStatus(Long statusId);
}
