package com.farmacia.module.proveedor.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.module.proveedor.domain.entity.Proveedor;
import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class ProveedorRepository implements ProveedorService{

    @Override
    public void createProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (nombre,contacto) VALUES (?,?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());

            statement.executeUpdate();
            System.out.println("proveedor creado: " + proveedor.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProveedor(int id) {
        String sql = "DELETE FROM proveedor WHERE id = ?";
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
    public List<Proveedor> findProveedorAll() {
        String sql = "SELECT id,nombre,contacto FROM proveedor";
        List<Proveedor> prov = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String contacto = resultSet.getString("contacto");

                Proveedor proveedor = new Proveedor(id, nombre,contacto);
                prov.add(proveedor);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prov;
    }

    @Override
    public Optional<Proveedor> findProveedorById(int id) {
        String sql = "SELECT id,nombre,contacto FROM proveedor WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String contacto = resultSet.getString("contacto");

                Proveedor proveedor = new Proveedor(id,nombre,contacto);
                return Optional.of(proveedor);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        String query = "UPDATE proveedor SET nombre = ?, contacto = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());
            statement.setInt(3, proveedor.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la ciudad: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
