package com.cursojava.projetowebservice.repositories;


import com.cursojava.projetowebservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * UserRepository: camada de acesso ao banco de dados para a entidade User.
 *
 * - Basta declarar a interface estendendo JpaRepository<Entity, ID>:
 * - O Spring Data JPA gera a implementação automaticamente em tempo de
 *   execução (proxy dinâmico), então não é preciso criar UserRepositoryImpl.
 * - Já traz métodos prontos: findAll(), findById(), save(), deleteById(), count().
 * - Aceita métodos de consulta pelo nome (ex.: findByEmail, existsByEmail);
 *   o Spring monta o SQL a partir do nome do método.
 * - A anotação @Repository é opcional na interface: o Spring a detecta
 *   se estiver num pacote abaixo da classe principal da aplicação.
 * - É injetada nos Services (@Autowired ou construtor).
 */

public interface UserRepository extends JpaRepository<User,Long> {

}
