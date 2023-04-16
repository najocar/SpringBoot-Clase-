package com.example.demo.services;

import com.example.demo.model.Producto;
import java.util.List;

public interface InterfaceProducto {

    List<Producto> getAllProduct();
    public Producto findById(int Id);

}