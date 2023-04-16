package com.example.demo.services;

import com.example.demo.model.Producto;
import com.example.demo.repository.RepositoryProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProducto implements InterfaceProducto {

    private RepositoryProduct productRepository;

    public ServicesProducto(RepositoryProduct repositoryProduct){
        this.productRepository = repositoryProduct;
    }

    @Override
    public List<Producto> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Producto findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Producto product){productRepository.save(product);}
}

