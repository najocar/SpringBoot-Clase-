package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerPrueba {

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
}