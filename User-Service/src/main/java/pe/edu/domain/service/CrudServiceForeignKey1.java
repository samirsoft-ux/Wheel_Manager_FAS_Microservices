package pe.edu.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CrudServiceForeignKey1 <T, IDModel1, IDModel2> {

    Page<T> getAllModelsByModel2Id (IDModel2 idModel2, Pageable pageable)throws  Exception;
    T getModelByIdAndModel2Id (IDModel2 idModel2, IDModel1 idModel1) throws  Exception;
    T create (IDModel2 idModel2, T model) throws Exception;
    T update (IDModel2 idModel2, IDModel1 idModel1, T details) throws Exception;
    ResponseEntity<?> delete(IDModel2 idModel2, IDModel1 idModel1) throws Exception;
}
