package com.farmacia.module.laboratorio.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.laboratorio.domain.entity.Laboratorio;
import com.farmacia.module.laboratorio.domain.service.LaboratorioService;


public class LaboratorioRepository implements LaboratorioService{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void createLaboratorio(Laboratorio laboratorio) {
        String sql = "INSERT INTO laboratorio (nombre) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, laboratorio.getNombre());

            statement.executeUpdate();
            System.out.println("laboratorio creado: " + laboratorio.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteLaboratorio(int id) {
        String sql = "DELETE FROM laboratorio WHERE id = ?";
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
    public List<Laboratorio> findLaboratorioAll() {
        String sql = "SELECT id,nombre FROM laboratorio";
        List<Laboratorio> laboratorio = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Laboratorio Laboratorio = new Laboratorio(id,nombre);
                laboratorio.add(Laboratorio);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratorio;
    }

    @Override
    public Optional<Laboratorio> findLaboratorioById(int id) {
        String sql = "SELECT id,nombre FROM laboratorio WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                Laboratorio labor = new Laboratorio(id,nombre);
                return Optional.of(labor);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updatelaboratorio(int id) {
        String query = "UPDATE laboratorio SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre del Laboratorio: ");
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
