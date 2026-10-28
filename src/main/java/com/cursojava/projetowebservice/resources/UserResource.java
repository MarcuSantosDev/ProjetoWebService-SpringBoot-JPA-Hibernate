package com.cursojava.projetowebservice.resources;

import com.cursojava.projetowebservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@gmail.com","81991883051","password");
        return ResponseEntity.ok().body(u);
    }

}
