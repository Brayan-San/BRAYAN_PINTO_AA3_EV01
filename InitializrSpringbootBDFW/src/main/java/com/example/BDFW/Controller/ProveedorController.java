package com.example.BDFW.controller;

import com.example.BDFW.model.Proveedor;
import com.example.BDFW.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // Define la clase como un controlador de Spring MVC
@RequestMapping("/proveedores") // Define la ruta base para todas las solicitudes relacionadas con proveedores
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService; // Inyecta el servicio de proveedores para manejar la lógica de negocio

    @GetMapping("/Listar")
    public String listarProveedores(Model model) {
        // Agrega la lista de proveedores al modelo para ser mostrada en la vista
        model.addAttribute("proveedores", proveedorService.listarTodos());
        return "listar"; // Renderiza la plantilla listar.html
    }

    @GetMapping("/Crear")
    public String mostrarFormularioCrear(Model model) {
        // Agrega un nuevo objeto Proveedor al modelo para que el formulario pueda llenarse
        model.addAttribute("proveedor", new Proveedor());
        return "crear"; // Renderiza la plantilla crear.html
    }

    @PostMapping("/Guardar")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        // Guarda el proveedor en la base de datos usando el servicio
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores/Listar"; // Redirige al listado de proveedores después de guardar
    }

    @GetMapping("/Editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        // Obtiene el proveedor por su ID y si existe, lo agrega al modelo para editar
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            return "editar"; // Renderiza la plantilla editar.html
        } else {
            return "redirect:/proveedores/Listar"; // Si no se encuentra el proveedor, redirige al listado
        }
    }

    @PostMapping("/Actualizar/{id}")
    public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("proveedor") Proveedor proveedor) {
        // Actualiza los datos del proveedor en la base de datos
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores/Listar"; // Redirige al listado de proveedores después de actualizar
    }

    @GetMapping("/Eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        // Elimina el proveedor por su ID
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedores/Listar"; // Redirige al listado después de eliminar
    }

    @GetMapping("/verTodo")
    public String verTodo(Model model) {
        // Muestra todos los proveedores en una vista detallada
        List<Proveedor> proveedores = proveedorService.listarTodos(); 
        model.addAttribute("proveedores", proveedores);
        return "verTodo"; // Renderiza la plantilla verTodo.html
    }
}
