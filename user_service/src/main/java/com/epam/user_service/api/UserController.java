package com.epam.user_service.api;

import com.epam.user_service.api.dto.UserDto;
import com.epam.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        log.info("GET Method -> Invoked /api/v1/user endpoint");
        List<UserDto> allUsers = this.userService.getAllUsers();
        return ResponseEntity.status((allUsers.size() > 0) ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(allUsers);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") final Long id) {
        log.info("GET Method -> Invoked /api/v1/user/{} endpoint", id);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUser(id));
        } catch (IllegalAccessException e) {
            log.error("GET Method -> Invoked /api/v1/user endpoint with exception: {}", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @NotNull @RequestBody final UserDto user) {
        log.info("POST Method -> Invoked /api/v1/user endpoint with paramters: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid @NotNull final UserDto user,
                                              @PathVariable("id") final Long id) {
        log.info("PUT Method -> Invoked /api/v1/user/{} endpoint with paramater: {}", id, user);
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.updateUser(id, user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        log.info("DELETE Method -> Invoked /api/v1/user/{} endpoint", id);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
    }
}
