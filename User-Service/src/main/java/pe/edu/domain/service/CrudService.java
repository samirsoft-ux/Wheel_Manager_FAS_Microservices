package pe.edu.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    Page<T> getAll(Pageable pageable)throws  Exception;
    T getModelById (ID id) throws  Exception;
    T create (T model) throws Exception;
    T update (ID id,T details) throws Exception;
    ResponseEntity<?> delete(ID id) throws Exception;

}
