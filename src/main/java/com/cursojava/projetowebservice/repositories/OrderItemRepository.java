package com.cursojava.projetowebservice.repositories;

import com.cursojava.projetowebservice.entities.OrderItem;
import com.cursojava.projetowebservice.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
