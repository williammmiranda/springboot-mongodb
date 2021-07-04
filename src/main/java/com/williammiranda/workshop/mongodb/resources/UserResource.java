package com.williammiranda.workshop.mongodb.resources;

import com.williammiranda.workshop.mongodb.domain.User;
import com.williammiranda.workshop.mongodb.services.UserService;
import com.williammiranda.workshop.mongodb.services.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(usuario -> new UserDTO(usuario)).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }
}
