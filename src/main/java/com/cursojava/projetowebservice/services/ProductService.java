package com.cursojava.projetowebservice.services;

import com.cursojava.projetowebservice.entities.Product;
import com.cursojava.projetowebservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        List<Product> list = repository.findAll();
        return list;
    }

    public Product findById(long id){
        Product obj = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return obj;

    }
}
