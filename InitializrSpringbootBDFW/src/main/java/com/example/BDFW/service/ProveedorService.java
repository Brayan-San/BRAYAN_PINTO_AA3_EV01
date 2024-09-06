package com.example.BDFW.service;

import com.example.BDFW.model.Proveedor;
import com.example.BDFW.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio de Spring
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository; // Inyecta el repositorio de proveedores

    // Método para obtener la lista de todos los proveedores
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll(); // Devuelve todos los registros de la tabla proveedor
    }

    // Método para guardar un proveedor (nuevo o actualizado) en la base de datos
    public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor); // Guarda o actualiza el proveedor
    }

    // Método para obtener un proveedor específico por su ID
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id); // Busca el proveedor por su ID
    }

    // Método para eliminar un proveedor por su ID
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id); // Elimina el proveedor por su ID
    }
}
