package com.farmacia.module.unidadMedida.infrastructure;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;
import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class UnidadMedidaRepository implements UnidadMedidaService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createUnidadMedida(UnidadMedida UnidadMedida) {
        String sql = "INSERT INTO unidad_medida (descripcion) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, UnidadMedida.getDescripcion());

            statement.executeUpdate();
            System.out.println("UnidadMedida creado: " + UnidadMedida.getDescripcion());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteUnidadMedida(int id) {
        String sql = "DELETE FROM unidad_medida WHERE id = ?";
        try (Connection connection =  database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<UnidadMedida> findAllUnidadMedida() {
        String sql = "SELECT id, descripcion FROM unidad_medida";
        List<UnidadMedida> um = new ArrayList<>();
        try (Connection connection = database.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                UnidadMedida unidadm = new UnidadMedida(descripcion);
                um.add(id,unidadm);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return um;
    }

    @Override
    public Optional<UnidadMedida> findUnidadMedidaById(int id) {
        String sql = "SELECT id,descripcion FROM unidad_medida WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                UnidadMedida unidadMedida = new UnidadMedida(nombre);
                return Optional.of(unidadMedida);
            }
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return Optional.empty();
    }

    @Override
    public void updateUnidadMedida(int id) {
        String query = "UPDATE unidad_medida SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre de la unidad de medida: ");
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


