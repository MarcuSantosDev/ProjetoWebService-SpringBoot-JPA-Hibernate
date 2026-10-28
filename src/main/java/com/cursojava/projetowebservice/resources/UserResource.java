package com.cursojava.projetowebservice.resources;

import com.cursojava.projetowebservice.entities.User;
import com.cursojava.projetowebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controllers são responsáveis por receber as requisições HTTP,
 * chamar os serviços (Services) e retornar as respostas ao cliente.
 *
 * Exemplos:
 * - @GetMapping: consultar dados.
 * - @PostMapping: cadastrar dados.
 * - @PutMapping: atualizar dados.
 * - @DeleteMapping: excluir dados.
 *
 * Exemplo: UserController recebe uma requisição para listar usuários
 * e chama o UserService para executar a operação.
 */


@RestController // Define um controlador REST
                //Recebe requisições HTTP e devolve os dados direto no corpo da resposta

@RequestMapping(value = "/users") // Define a rota base dos endpoints.
public class UserResource {

    @Autowired // Injeção de Dependência , UserService precisa tá registrado como componente do Spring
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){ // Recebe o id da url
        User user = service.findUserById(id);
        return ResponseEntity.ok().body(user);
    }



}
