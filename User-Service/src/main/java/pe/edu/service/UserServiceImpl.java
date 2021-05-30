package pe.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.domain.model.User;
import pe.edu.domain.repository.UserRepository;
import pe.edu.domain.service.UserService;
import pe.edu.exception.ResourceNotFoundException;

import java.util.Optional;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;





    @Override
    public Page<User> getAll(Pageable pageable) throws Exception {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getModelById(Long userId) throws Exception {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));

    }

    @Override
    public User create(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, User userDetails) throws Exception {
        return userRepository.findById(userId).map(user -> {
            user.setDni(userDetails.getDni());
            user.setUserName(userDetails.getUserName());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setLastName(userDetails.getLastName());
            user.setGender(userDetails.getGender());
            user.setBirthDay(userDetails.getBirthDay());
            user.setName(userDetails.getName());
            return userRepository.save(user);
        }).orElseThrow(()->new ResourceNotFoundException("Client","Id",userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) throws Exception {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
    }
}
