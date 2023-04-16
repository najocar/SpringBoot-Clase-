package com.example.demo.controllers;

import com.example.demo.model.Producto;
import com.example.demo.services.ServicesProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControllerPrueba {

    private ServicesProducto productServices;

    public ControllerPrueba(ServicesProducto productServices){
        this.productServices = productServices;
    }

   /* @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    @GetMapping("/greeting/{nombre}/{edad}")
    public String hola(Model model, @PathVariable(name = "nombre") String nombre,
                       @PathVariable(name = "edad") int edad) {
        model.addAttribute("name", nombre);
        model.addAttribute("edad", edad);
        model.addAttribute("hola", "hola soy jose carlos");
        return "greeting";
    }

    @GetMapping("/productos") // Acceso a datos mediante query (List)
    public String productList(Model model){
        List<Producto> productos = productServices.getAllProduct();
        model.addAttribute("productos", productos);
        return "productosList"; // implementacion de stylo mediante css y bootstrap
    }

    @GetMapping("/productos/registro")
    public String formProduct(Model model){
        model.addAttribute("product", new Producto());
        return "registroProducto";
    }

    @PostMapping("/productos/registro")
    public Object saveProduct(@ModelAttribute("product") Producto producto){
        productServices.save(producto);
        return new RedirectView("/productos");
    }
}