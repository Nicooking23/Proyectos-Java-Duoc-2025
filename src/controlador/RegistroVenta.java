    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dataBase.Conexion;
import java.util.Date;
import modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nicooking23
 */
public class RegistroVenta {
    public boolean agregarVenta(Venta venta){
        
        try {
            Date date;
            //Establezco Conexion
            Connection cnx = Conexion.getConexion();
            date = venta.getFecha_venta();
            //definir un string para crear la instrucción
            String query ="INSERT INTO venta(fecha_venta, id_producto, id_cliente, "
                        + "cantidad, total, metodo_pago) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setDate(1, new java.sql.Date(venta.getFecha_venta().getTime()));
            stmt.setInt(2, venta.getId_producto());
            stmt.setInt(3, venta.getId_cliente());
            stmt.setInt(4, venta.getCantidad());
            stmt.setInt(5, venta.getTotal());
            stmt.setString(6, venta.getMetodo_pago());
            //ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch(SQLException e){
            System.out.println("Error SQL - Agregar: " + e.toString());
            return false;
        } catch (Exception e) {
            System.out.println("Error - Agregar: " + e.toString());
            return false;
        }        

    }
    
    public boolean actualizarVenta(Venta venta){
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "UPDATE venta SET fecha_venta= ?,id_producto= ?,id_cliente= ?,"
                         + "cantidad= ?,total= ?,metodo_pago= ? WHERE id_venta= ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setDate(1, new java.sql.Date(venta.getFecha_venta().getTime()));
            stmt.setInt(2, venta.getId_producto());
            stmt.setInt(3, venta.getId_cliente());
            stmt.setInt(4, venta.getCantidad());
            stmt.setInt(5, venta.getTotal());
            stmt.setString(6, venta.getMetodo_pago());
            stmt.setInt(7, venta.getId_venta());
            //ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch(SQLException e){
            System.out.println("Error SQL - Modificar: " + e.toString());
            return false;
        } catch (Exception e) {
            System.out.println("Error - Modificar: " + e.toString());
            return false;
        }        

    }
    
    public Venta buscarUnaVenta(int id_venta){
        Venta venta = new Venta();
        try {
            //establezco conexión
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_venta, fecha_venta, id_producto, id_cliente, "
                         + "cantidad, total, metodo_pago FROM venta WHERE id_venta= ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setInt(1, id_venta);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setFecha_venta(rs.getDate("fecha_venta"));
                venta.setId_producto(rs.getInt("id_producto"));
                venta.setId_cliente(rs.getInt("id_cliente"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setTotal(rs.getInt("total"));
                venta.setMetodo_pago(rs.getString("metodo_pago"));
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL - Agregar Cliente: " + e.toString());
        } catch (Exception e) { 
            System.out.println("Error - Agregar Cliente: " + e.toString());
        }
        return venta;
    }
    
    public ArrayList<Venta> buscarTodos(){
        ArrayList<Venta> listaVenta = new ArrayList<>();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_venta, fecha_venta, id_producto, id_cliente, "
                         + "cantidad, total, metodo_pago FROM venta";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Venta venta = new Venta();
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setFecha_venta(rs.getDate("fecha_venta"));
                venta.setId_producto(rs.getInt("id_producto"));
                venta.setId_cliente(rs.getInt("id_cliente"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setTotal(rs.getInt("total"));
                venta.setMetodo_pago(rs.getString("metodo_pago"));
                listaVenta.add(venta);
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch(SQLException e){
            System.out.println("Error SQL - buscarTodos: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - buscarTodos: " + e.toString());
        }  
        return listaVenta;
    }
}
