package com.farmacia.module.PrincipioActivo.infrastruture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;
import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;



public class PrincipioActivoRepository implements PrincipioActivoService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void createPrincipioActivo(PrincipioActivo principioActivo) {
        String sql = "INSERT INTO principio_activo (nombre) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, principioActivo.getNombre());

            statement.executeUpdate();
            System.out.println("Principio Activo creado: " + principioActivo.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deletePrincipioActivo(int id) {
        String sql = "DELETE FROM principio_activo WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<PrincipioActivo> findAllPrincipioActivo() {
        String sql = "SELECT id,nombre FROM principio_activo";
        List<PrincipioActivo> principioActivo = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                PrincipioActivo principio = new PrincipioActivo(id,nombre);
                principioActivo.add(principio);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return principioActivo;
    }

    @Override
    public Optional<PrincipioActivo> findPrincipioActivoById(int id) {
        String sql = "SELECT id,nombre FROM principio_activo WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                PrincipioActivo principioActivo = new PrincipioActivo(id,nombre);
                return Optional.of(principioActivo);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updatePrincipioActivo(int id) {
        String query = "UPDATE principio_activo SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre del principio activo: ");
            String nombre = scanner.nextLine();
            statement.setString(1, nombre);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
