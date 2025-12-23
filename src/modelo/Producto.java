/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nicooking23
 */
public class Producto {
    //<editor-fold defaultstate="collapsed" desc="atributos">
    
    private int id_producto,precio,stock;
    private String nombre,descripcion,ingredientes;
    private String categoria;
    private boolean estado;
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constructores">
   
    public Producto() {
    }

    public Producto(int id_producto, int precio, int stock, String nombre, String descripcion, String ingredientes, String categoria, boolean estado) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.categoria = categoria;
        this.estado = estado;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get&set">
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Customers">
    
    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", precio=" + precio + ", stock=" + stock + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ingredientes=" + ingredientes + ", categoria=" + categoria + ", estado=" + estado + '}';
    }
    
    //</editor-fold>
}
