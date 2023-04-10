package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data//lombok
@Entity//Es una entidad
@Table(name="CarritoCompra")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "nombre", nullable = false)
    public String nombre;

    @Column(name = "precio")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double precio;

    @ManyToMany
    @JoinTable(name = "carrito_compra_productoopes",
            joinColumns = @JoinColumn(name = "carrito_id"),
            inverseJoinColumns = @JoinColumn(name = "productoes_id"))
    private List<Producto> productoes = new ArrayList<>();

}
