/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dataBase.Conexion;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nicooking23
 */
public class RegistroCliente {
    public boolean agregarCliente(Cliente cliente){
        Date date;
        try {
            //Establezco Conexion
            Connection cnx = Conexion.getConexion();
            date = cliente.getFecha_nacimiento();
            //definir un string para crear la instrucción
            String query = "INSERT INTO cliente(nombre, fecha_nacimiento, direccion, "
                         + "email, telefono, tipo) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setString(1, cliente.getNombre());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getTelefono());
            stmt.setString(6, cliente.getTipo());
            //Ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL - Agregar Cliente: " + e.toString());
            return false;
        } catch (Exception e) { 
            System.out.println("Error - Agregar Cliente: " + e.toString());
            return false;
        }
    }
    
    public boolean actualizarCliente(Cliente cliente){
        Date date;
        try {
            Connection cnx = Conexion.getConexion();
            date = cliente.getFecha_nacimiento();
            String query = "UPDATE cliente SET nombre= ?,fecha_nacimiento= ?,"
                         + "direccion= ?,email= ?,telefono= ?,tipo= ? WHERE id_cliente=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //completar los parametros
            stmt.setString(1, cliente.getNombre());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getTelefono());
            stmt.setString(6, cliente.getTipo());
            stmt.setInt(7, cliente.getId_cliente());
            //Ejecutar la instrucción en la BD
            stmt.executeUpdate();
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL - Agregar Cliente: " + e.toString());
            return false;
        } catch (Exception e) { 
            System.out.println("Error - Agregar Cliente: " + e.toString());
            return false;
        }
    }
    
    public boolean eliminarCliente(int id_cliente){
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //Completar los parametros
            stmt.setInt(1, id_cliente);
            //Ejecutar la instruccion en la BD
            stmt.executeUpdate();
            //cierro objetos y conexion
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
    
    public Cliente buscarUnCliente(int id_cliente){
        Cliente cliente = new Cliente();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_cliente, nombre, fecha_nacimiento, direccion, "
                         + "email, telefono, tipo FROM cliente WHERE id_cliente =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_cliente);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setTipo(rs.getString("tipo"));
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch(SQLException e){
            System.out.println("Error SQL - buscarUnLibro: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - buscarUnLibro: " + e.toString());
        }   
        return cliente;
    }
    
    public ArrayList<Cliente> buscarTodos(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_cliente, nombre, fecha_nacimiento, direccion, "
                         + "email, telefono, tipo FROM cliente";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setTipo(rs.getString("tipo"));
                listaClientes.add(cliente);
            }
            //Cierro los objetos y conexion
            stmt.close();
            cnx.close();
            rs.close();
        } catch(SQLException e){
            System.out.println("Error SQL - buscarTodos: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - buscarTodos: " + e.toString());
        }  
        return listaClientes;
    }

        public Cliente buscarUnClienteNombre(String nombre){
        Cliente cliente = new Cliente();
        try {
            //Establezco conexion
            Connection cnx = Conexion.getConexion();
            //definir un string para crear la instrucción
            String query = "SELECT id_cliente, nombre, fecha_nacimiento, direccion, "
                         + "email, telefono, tipo FROM cliente WHERE nombre =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);
            //ejecutar la instrucción en la BD
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setTipo(rs.getString("tipo"));
            }
            //cierro objetos y conexión
            stmt.close();
            cnx.close();
            rs.close();
        } catch(SQLException e){
            System.out.println("Error SQL - buscarUnLibro: " + e.toString());
        } catch (Exception e) {
            System.out.println("Error - buscarUnLibro: " + e.toString());
        }   
        return cliente;
    }
    
}
