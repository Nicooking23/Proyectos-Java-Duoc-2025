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
public class Venta {
    //<editor-fold defaultstate="collapsed" desc="atributos">
    
    private int id_venta,id_producto,id_cliente,cantidad,total;
    private Date fecha_venta;
    private String metodo_pago;
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constructores">
    
    public Venta() {
    }

    public Venta(int id_venta, int id_producto, int id_cliente, int cantidad, int total, Date fecha_venta, String metodo_pago) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.id_cliente = id_cliente;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha_venta = fecha_venta;
        this.metodo_pago = metodo_pago;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get&set">
    
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Customers">
    
    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", id_producto=" + id_producto + ", id_cliente=" + id_cliente + ", cantidad=" + cantidad + ", total=" + total + ", fecha_venta=" + fecha_venta + ", metodo_pago=" + metodo_pago + '}';
    }
    
    //</editor-fold>
    
}
