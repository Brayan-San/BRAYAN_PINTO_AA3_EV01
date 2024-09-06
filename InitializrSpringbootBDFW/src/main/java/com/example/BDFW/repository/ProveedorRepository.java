package com.example.BDFW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BDFW.model.Proveedor;

// Interfaz que extiende JpaRepository, proporcionando operaciones CRUD predeterminadas para la entidad Proveedor
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
