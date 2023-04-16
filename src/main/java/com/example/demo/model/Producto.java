package com.example.demo.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.Serializable;

@Data //lombok
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name="nombre", nullable = false)
    public String nombre;

    @Column(name="precio")
    public double precio;


}
