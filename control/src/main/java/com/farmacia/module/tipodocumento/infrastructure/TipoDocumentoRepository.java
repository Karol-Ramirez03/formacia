package com.farmacia.module.tipodocumento.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.database.database;
import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;
import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class TipoDocumentoRepository implements TipoDocumentoService {
    Scanner sc = new Scanner(System.in);

    @Override
    public void createTipoDocumento(TipoDocumento TipoDocumento) {
        String sql = "INSERT INTO tipodocumento (nombre) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, TipoDocumento.getNombre());

            statement.executeUpdate();
            System.out.println("tipodocumento creado: " + TipoDocumento.getNombre());
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteTipoDocumento(int id) {
        String sql = "DELETE FROM tipodocumento WHERE id = ?";
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
    public List<TipoDocumento> findAllTipoDocumento() {
       String sql = "SELECT id,nombre FROM tipodocumento";
        List<TipoDocumento> tipodocumento = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                TipoDocumento doc = new TipoDocumento(id,nombre );
                tipodocumento.add(doc);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipodocumento;
    }
    

    @Override
    public Optional<TipoDocumento> findTipoDocumentoById(int id) {
        String sql = "SELECT id,nombre FROM tipodocumento WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                TipoDocumento document = new TipoDocumento(id,nombre);
                return Optional.of(document);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateTipoDocumento(int id) {
        String query = "UPDATE tipodocumento SET nombre = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
        
            System.out.print("Ingrese el nombre de tipodocumento: ");
            String nombre = sc.nextLine();
            statement.setString(1, nombre);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
