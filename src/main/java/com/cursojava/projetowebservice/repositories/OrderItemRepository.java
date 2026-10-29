package com.cursojava.projetowebservice.repositories;

import com.cursojava.projetowebservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
