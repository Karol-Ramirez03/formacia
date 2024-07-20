package com.farmacia.module.cliente.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;
import java.sql.Statement;

import com.farmacia.database.database;
import com.farmacia.module.cliente.domain.entity.cliente;
import com.farmacia.module.cliente.domain.service.clienteService;

public class clienteRepository implements clienteService {
    
    @Override
    public Optional<cliente> findbyid(String id) {
       String sql = "SELECT id, tipoDocumento, nombres, apellidos, edad, fechaNacimiento, barrio FROM cliente WHERE id = ?";
       try (Connection connection = database.getConnection();
       PreparedStatement ps = connection.prepareStatement(sql)){
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("nombres");
            String apellido = rs.getString("apellidos");
            int edad = rs.getInt("edad");
            

            cliente cliente = new cliente(id, nombre, apellido, edad);
            return Optional.of(cliente);
        }

        
       } catch (SQLException e) {
         e.printStackTrace();
       }
       return Optional.empty();
    }

    public void add(cliente cliente) {
        String sql = "INSERT INTO cliente (id, tipoDocumento, nombres, apellidos, edad, fechaNacimiento, barrio) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement statement =connection.prepareStatement(sql)){
            statement.setString(1, cliente.getId());
            statement.setInt(2, cliente.getTipoDocumento());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellidos());
            statement.setInt(5, cliente.getEdad());
            statement.setDate(6, new Date(cliente.getFechaNacimiento().getTime()));
            statement.setInt(7, cliente.getBarrio());

            statement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<cliente> findAll() {
        List<cliente> clientes = new ArrayList<>();;
        String sql = "SELECT id, tipoDocumento, nombres, apellidos, edad, fechaNacimiento, barrio FROM cliente";
        try (Connection connection = database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);){
                while (rs.next()){
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombres");
                    String apellido = rs.getString("apellidos");
                    int edad = rs.getInt("edad");

                    cliente client = new cliente(id, nombre, apellido, edad);
                    clientes.add(client);
                }
                connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(cliente cliente) {
        String query = "UPDATE cliente SET nombres = ?, tipoDocumento = ?, apellidos = ?, edad = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(3, cliente.getApellidos());
            statement.setInt(4, cliente.getEdad());
            statement.setString(5, cliente.getId());
    
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
