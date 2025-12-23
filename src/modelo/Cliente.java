/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Nicooking23
 */
public class Cliente {
    //<editor-fold defaultstate="collapsed" desc="atributos">
    
    private int id_cliente,telefono;
    private String nombre,direccion,email,tipo;
    private Date fecha_nacimiento;
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constructores">
    
    public Cliente() {
    }

    public Cliente(int id_cliente, int telefono, String nombre, String direccion, String email, String tipo, Date fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.tipo = tipo;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get&set">
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="customers">
    
    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", telefono=" + telefono + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", tipo=" + tipo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
    //</editor-fold>
    
}
