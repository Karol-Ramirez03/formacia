package com.farmacia.module.barrio.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.module.barrio.domain.entity.Barrio;
import com.farmacia.module.barrio.domain.service.BarrioService;

public class BarrioRepository implements BarrioService {

    @Override
    public void createBarrio(Barrio Barrio) {
        String sql = "INSERT INTO barrio (nombres,ciudad) VALUES (?,?)";
        try (Connection connection = database.getConnection();
        PreparedStatement statement =connection.prepareStatement(sql)){
           
            statement.setString(1, Barrio.getNombre());
            statement.setInt(2, Barrio.getCiudad());
            statement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteBarrio(int id) {
        String sql = "DELETE FROM barrio WHERE id = ?";
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
    public List<Barrio> findAllBarrio() {
        List<Barrio> barrio = new ArrayList<>();;
        String sql = "SELECT id, nombre, ciudad FROM barrio";
        try (Connection connection = database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombres");
                    int ciudad = rs.getInt("ciudad");
                    Barrio barrios = new Barrio(id, nombre, ciudad);
                    barrio.add(barrios);
                }
                connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barrio;
    }

    @Override
    public Optional<Barrio> findBarrioById(int id) {
        String sql = "SELECT id, nombre, ciudad FROM barrio WHERE id = ?  ";
        
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int ciudad = rs.getInt("ciudad");

                Barrio barrio = new Barrio(id, nombre,ciudad);
                return Optional.of(barrio);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Optional.empty();
    }

    @Override
    public void updateBarrio(Barrio Barrio) {
        String query = "UPDATE cliente SET nombres = ?, ciudad = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, Barrio.getNombre());
            statement.setInt(2, Barrio.getCiudad());
            statement.setInt(3, Barrio.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
