package pe.edu.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.domain.model.Address;
import pe.edu.domain.model.User;

public interface UserService extends CrudService<User,Long> {

}
