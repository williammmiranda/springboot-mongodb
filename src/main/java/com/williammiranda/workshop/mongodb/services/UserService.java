package com.williammiranda.workshop.mongodb.services;

import com.williammiranda.workshop.mongodb.domain.User;
import com.williammiranda.workshop.mongodb.gateway.database.repository.UserRepository;
import com.williammiranda.workshop.mongodb.resources.domain.UserDTO;
import com.williammiranda.workshop.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){ return userRepository.findAll(); };

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newUsuario = findById(user.getId());
        updateData(newUsuario, user);
        return userRepository.save(newUsuario);
    }

    private void updateData(User newUsuario, User user) {
        newUsuario.setName(user.getName());
        newUsuario.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
