package com.farmacia.module.pais.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.pais.domain.entity.Pais;
import com.farmacia.module.pais.domain.service.paisService;

public class paisRepository implements paisService {

    Scanner scanner = new Scanner(System.in);
    @Override
    public void createPais(Pais Pais) {
        String sql = "INSERT INTO pais (nombre) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, Pais.getNombre());

            statement.executeUpdate();
            System.out.println("pais creado: " + Pais.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePais(int id) {
        String query = "UPDATE pais SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre del pais: ");
            String nombre = scanner.nextLine();
            statement.setString(1, nombre);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void deletePais(int id) {
        String sql = "DELETE FROM pais WHERE id = ?";
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
    public Optional<Pais> findPaisById(int id) {
        String sql = "SELECT * FROM pais WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                Pais pais = new Pais(nombre);
                return Optional.of(pais);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public List<Pais> findAllPais() {
        String sql = "SELECT * FROM pais";
        List<Pais> paises = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Pais pais = new Pais(nombre, id);
                paises.add(pais);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }

}
