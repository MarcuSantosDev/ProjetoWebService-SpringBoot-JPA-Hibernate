package com.cursojava.projetowebservice.entities;

import com.cursojava.projetowebservice.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.aspectj.weaver.ast.Or;

import java.util.Objects;

@Entity
@Table(name="tb_order_item")
public class OrderItem {
    private static final long serialVersionUID = 1L;

    @EmbeddedId // Indica que o ID desta entidade é uma classe @Embeddabl
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
