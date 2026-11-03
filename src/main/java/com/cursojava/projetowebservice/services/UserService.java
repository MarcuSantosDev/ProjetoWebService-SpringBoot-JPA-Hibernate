package com.cursojava.projetowebservice.services;

import com.cursojava.projetowebservice.entities.User;
import com.cursojava.projetowebservice.repositories.UserRepository;
import com.cursojava.projetowebservice.services.exceptions.ResourceNotFoundException;
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
        Optional<User> obj =  repository.findById(id); // Vai até o banco de dados para encontrar o user by id
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Tenta dar o Get senão conseguir retorna a exceção
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id); // Instancia o usuário, sem ter q acessar o banco pra buscar
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
