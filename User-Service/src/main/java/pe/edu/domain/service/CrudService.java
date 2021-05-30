package pe.edu.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    Page<T> getAllModels(Pageable pageable);
    T getModelById (ID id) ;
    T create (T model) ;
    T update (ID id,T details) ;
    ResponseEntity<?> delete(ID id) ;

}
