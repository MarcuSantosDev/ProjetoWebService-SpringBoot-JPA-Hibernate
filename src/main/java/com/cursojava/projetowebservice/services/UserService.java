package com.cursojava.projetowebservice.services;

import com.cursojava.projetowebservice.entities.User;
import com.cursojava.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // @Service registra a classe como bean do Spring, permitindo injetá-la em outras classes.
public class UserService {

    @Autowired // Solicita ao Spring a injeção automática de uma dependência gerenciada pelo contêiner (bean).
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> obj =  repository.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }
}
