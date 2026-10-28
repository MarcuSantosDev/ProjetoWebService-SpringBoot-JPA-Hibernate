package com.cursojava.projetowebservice.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/*
 * Convenção e recomendação do JPA: a especificação recomenda que entidades sejam serializáveis.
 *
 * Usos comuns:
 * - Salvar o estado do objeto em arquivo.
 * - Enviar objetos pela rede (RMI, filas de mensagens).
 * - Sessão HTTP: replicar ou manter a sessão após reinício do servidor.
 * - Cache distribuído (Redis, Hazelcast, Ehcache).
 * - JPA/Hibernate: recomendado em entidades, principalmente chaves compostas
 *   e quando usadas em sessão ou cache.
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
