package com.farmacia.module.ciudad.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.module.ciudad.domain.entity.Ciudad;
import com.farmacia.module.ciudad.domain.service.CiudadService;

public class CiudadRepository implements CiudadService {

    @Override
    public void createCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad (nombres,pais) VALUES (?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement statement =connection.prepareStatement(sql)){
           
            statement.setString(1, ciudad.getNombre());
            statement.setInt(2, ciudad.getid_pais());
            statement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteCiudad(int id) {
        String sql = "DELETE FROM ciudad WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Ciudad> findAllCiudad() {
        List<Ciudad> ciudad = new ArrayList<>();;
        String sql = "SELECT id, nombre, pais FROM ciudad";
        try (Connection connection = database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombres");
                    int pais = rs.getInt("pais");
                    Ciudad Ciudad = new Ciudad(id, nombre, pais);
                    ciudad.add(Ciudad);
                }
                connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudad;
    }

    @Override
    public Optional<Ciudad> findCiudadById(int id) {
        String sql = "SELECT id, nombre, pais FROM ciudad WHERE id = ?  ";
        
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int pais = rs.getInt("pais");

                

                Ciudad ciudad = new Ciudad(id, nombre,pais);
                return Optional.of(ciudad);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Optional.empty();
    }

    @Override
    public void updateCiudad(Ciudad ciudad) {
        String query = "UPDATE cliente SET nombres = ?, Id_ciudad = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ciudad.getNombre());
            statement.setInt(2, ciudad.getid_pais());
            statement.setInt(3, ciudad.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}







