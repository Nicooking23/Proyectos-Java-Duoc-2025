/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dataBase.Conexion;
import modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nicooking23
 */
public class RegistroProducto {
    public boolean agregarProducto(Producto producto){
        try {
            //Establezco Conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "INSERT INTO producto (nombre, categoria, descripcion, "
                    + "ingredientes, precio, stock, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setString(3, producto.getDescripcion());
            stmt.setString(4, producto.getIngredientes());
            stmt.setInt(5, producto.getPrecio());
            stmt.setInt(6, producto.getStock());
            stmt.setBoolean(7, producto.isEstado());
            //Ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL - Agregar: " + e.toString());
            return false;
        } catch (Exception e){
            System.out.println("Error - Agregar: " + e.toString());
            return false;
        }
    }
    
    public boolean actualizarProducto(Producto producto){
        try {
            //Establezco Conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "UPDATE producto SET nombre= ?,categoria= ?,"
                         + "descripcion= ?,ingredientes= ?,precio= ?,"
                         + "stock= ?,estado= ? WHERE id_producto= ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setString(3, producto.getDescripcion());
            stmt.setString(4, producto.getIngredientes());
            stmt.setInt(5, producto.getPrecio());
            stmt.setInt(6, producto.getStock());
            stmt.setBoolean(7, producto.isEstado());
            stmt.setInt(8, producto.getId_producto());
            //Ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL - Modificar: " + e.toString());
            return false;
        } catch (Exception e){
            System.out.println("Error - Modificar: " + e.toString());
            return false;
        }
    }
        
    public boolean eliminarProducto(int id_producto){
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "DELETE FROM producto WHERE id_producto= ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setInt(1, id_producto);
            //ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL - Eliminar: " + e.toString());
            return false;
        } catch (Exception e){
            System.out.println("Error - Eliminar: " + e.toString());
            return false;
        }
        
    }

    public Producto buscarUnProducto(int id_producto){
        Producto producto = new Producto();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_producto, nombre, categoria, descripcion, "
                         + "ingredientes, precio, stock, estado FROM producto"
                         + " WHERE id_producto =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_producto);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setIngredientes(rs.getString("ingredientes"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error SQL - Buscar un producto: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - Buscar un producto: " + e.toString());
        }
        return producto;
    }
    
    public ArrayList<Producto> buscarTodos(){
        ArrayList<Producto> listarProductos = new ArrayList();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_producto, nombre, categoria, descripcion, "
                         + "ingredientes, precio, stock, estado FROM producto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setIngredientes(rs.getString("ingredientes"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                listarProductos.add(producto);
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error SQL - BuscarTodos: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - BuscarTodos: " + e.toString());
        }
        return listarProductos;
    }
    
    public ArrayList<Producto> categoriasUnicas(){
        ArrayList<Producto> listaCategorias = new ArrayList<>();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT DISTINCT categoria FROM producto ORDER BY categoria";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //ejecutar instruccion en la BD
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setCategoria(rs.getString("categoria"));
                listaCategorias.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL - CategoriasUnicas " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - CategoriasUnicas " + e.toString());
        }
        return listaCategorias;
    }
    
public Producto buscarUnProductoNombre(String nombre){
        Producto producto = new Producto();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_producto, nombre, categoria, descripcion, "
                         + "ingredientes, precio, stock, estado FROM producto "
                         + "WHERE nombre =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setIngredientes(rs.getString("ingredientes"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error SQL - Buscar un producto: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - Buscar un producto: " + e.toString());
        }
        return producto;
    }
    
}
