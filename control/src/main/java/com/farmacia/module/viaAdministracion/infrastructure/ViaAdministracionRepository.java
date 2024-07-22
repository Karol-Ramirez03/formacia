package com.farmacia.module.viaAdministracion.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;
import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class ViaAdministracionRepository implements ViaAdministracionService {
 Scanner scanner = new Scanner(System.in);

    @Override
    public void createViaAdministracion(ViaAdministracion viaAdministracion) {
        String sql = "INSERT INTO via_administracion  (descripcion) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, viaAdministracion.getDescripcion());

            statement.executeUpdate();
            System.out.println("via de administracion creado: " + viaAdministracion.getDescripcion());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteViaAdministracion(int id) {
        String sql = "DELETE FROM via_administracion WHERE id = ?";
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
    public List<ViaAdministracion> findAllViaAdministracion() {
        String sql = "SELECT id, descripcion FROM via_administracion";
        List<ViaAdministracion> via = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("descripcion");
                ViaAdministracion viaAdmin = new ViaAdministracion(id, nombre);
                via.add(viaAdmin);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return via;
    }

    @Override
    public Optional<ViaAdministracion> findViaAdministracionById(int id) {
        String sql = "SELECT id, descripcion FROM via_administracion WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("descripcion");
                ViaAdministracion via = new ViaAdministracion(id, nombre);
                return Optional.of(via);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateViaAdministracion(int id) {
        String query = "UPDATE via_administracion SET descripcion = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre de la via de administracion: ");
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
