package com.cursojava.projetowebservice.resources;

import com.cursojava.projetowebservice.entities.User;
import com.cursojava.projetowebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){ // Indica que esse objeto vai desseralizado para um User
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj); // HTTPS 201 precisa usar o created() que retorna um tipo URI


    }



}
