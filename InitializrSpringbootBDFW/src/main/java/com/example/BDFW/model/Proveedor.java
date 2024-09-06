package com.example.BDFW.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica que esta clase es una entidad JPA que se mapeará a una tabla en la base de datos
public class Proveedor {

    @Id // Indica que el campo id es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria se genera automáticamente
    private Long id;

    private String nombre; // Campo para el nombre del proveedor
    private String direccion; // Campo para la dirección del proveedor
    private String correo; // Campo para el correo del proveedor
    private String tipoTelefono; // Campo para el tipo de teléfono del proveedor
    private String telefono; // Campo para el teléfono del proveedor
    private String tipoProducto; // Campo para el tipo de producto que ofrece el proveedor
    private String nombreProducto; // Campo para el nombre del producto que ofrece el proveedor

    // Getters y Setters: permiten acceder y modificar los campos privados desde otras clases

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
