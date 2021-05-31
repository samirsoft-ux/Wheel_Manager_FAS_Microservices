package pe.edu.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.domain.model.User;
import pe.edu.domain.repository.UserRepository;
import pe.edu.domain.service.UserService;
import pe.edu.resource.SaveUserResource;
import pe.edu.resource.UserResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Tag(name="Users",description = "Users API")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable) {

        Page<User> usersPage = userService.getAllModels(pageable);
        List<UserResource> resources = usersPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable(value = "userId") Long userId) {
        return convertToResource(userService.getModelById(userId));
    }

    @PostMapping("/users")
    public UserResource createUser(
            @Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.create(user));

    }

    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId,
                                   @Valid @RequestBody SaveUserResource resource) {
        User user= convertToEntity(resource);
        return convertToResource(
                userService.update(userId, user));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }



    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }

}
