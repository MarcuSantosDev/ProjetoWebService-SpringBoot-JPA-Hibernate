package com.cursojava.projetowebservice.repositories;

import com.cursojava.projetowebservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
