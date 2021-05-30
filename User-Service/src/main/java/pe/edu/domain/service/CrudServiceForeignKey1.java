package pe.edu.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CrudServiceForeignKey1 <T, IDModel1, IDModel2> {

    Page<T> getAllModelsByModel2Id (IDModel2 idModel2, Pageable pageable);
    T getModelByIdAndModel2Id (IDModel2 idModel2, IDModel1 idModel1) ;
    T create (IDModel2 idModel2, T model) ;
    T update (IDModel2 idModel2, IDModel1 idModel1, T details) ;
    ResponseEntity<?> delete(IDModel2 idModel2, IDModel1 idModel1) ;
}
