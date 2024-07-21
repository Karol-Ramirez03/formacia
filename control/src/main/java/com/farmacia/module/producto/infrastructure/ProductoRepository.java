package com.farmacia.module.producto.infrastructure;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacia.database.database;
import com.farmacia.module.producto.domain.entity.Producto;
import com.farmacia.module.producto.domain.service.ProductoService;

public class ProductoRepository implements ProductoService {

    @Override
    public void add(Producto producto) {
        String sql = "INSERT INTO producto (codigo_producto, nombre_producto, registro_invima, via_administracion_id, principio_activo_id, unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, valor_compra, margen_ganancia, stock, stock_min, stock_max) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, producto.getCodigoProducto());
            statement.setString(2, producto.getNombreProducto());
            statement.setString(3, producto.getRegistroInvima());
            statement.setInt(4, producto.getViaAdministracion());
            statement.setInt(5, producto.getPrincipioActivo());
            statement.setInt(6, producto.getUnidadMedida());
            statement.setInt(7, producto.getLaboratorio());
            statement.setInt(8, producto.getProveedor());
            statement.setString(9, producto.getPresentacion());
            statement.setDate(10, new Date(producto.getFechaCaducidad().getTime())); // Usa java.sql.Date para fechas
            statement.setDouble(11, producto.getValorCompra());
            statement.setDouble(12, producto.getMargenGanancia());
            statement.setInt(13, producto.getStock());
            statement.setInt(14, producto.getStockMin());
            statement.setInt(15, producto.getStockMax());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String codigo) {
        String sql = "DELETE FROM producto WHERE codigo_producto = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT codigo_producto, nombre_producto, registro_invima, via_administracion_id, principio_activo_id, unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, valor_compra, margen_ganancia, stock, stock_min, stock_max, valor_venta FROM producto";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String codigoProducto = rs.getString("codigo_producto");
                String nombreProducto = rs.getString("nombre_producto");
                String registroInvima = rs.getString("registro_invima");
                int viaAdministracion = rs.getInt("via_administracion_id");
                int principioActivo = rs.getInt("principio_activo_id");
                int unidadMedida = rs.getInt("unidad_medida_id");
                int laboratorio = rs.getInt("laboratorio_id");
                int proveedor = rs.getInt("proveedor_id");
                String presentacion = rs.getString("presentacion");
                Date fechaCaducidad = rs.getDate("fecha_caducidad");
                double valorCompra = rs.getDouble("valor_compra");
                double margenGanancia = rs.getDouble("margen_ganancia");
                int stock = rs.getInt("stock");
                int stockMin = rs.getInt("stock_min");
                int stockMax = rs.getInt("stock_max");
                double valorVenta = rs.getDouble("valor_venta");

                Producto producto = new Producto(codigoProducto,nombreProducto,registroInvima,viaAdministracion,principioActivo,unidadMedida,laboratorio,proveedor,presentacion,fechaCaducidad,valorCompra,margenGanancia,stock,stockMin,stockMax,valorVenta);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Optional<Producto> findbyid(String codigo) {
        String sql = "SELECT codigo_producto, nombre_producto, registro_invima, via_administracion_id, principio_activo_id, unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, valor_compra, margen_ganancia, stock, stock_min, stock_max, valor_venta FROM producto WHERE codigo_producto = ?";
        
        try (Connection connection = database.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombreProducto = rs.getString("nombre_producto");
                String registroInvima = rs.getString("registro_invima");
                int viaAdministracion = rs.getInt("via_administracion_id");
                int principioActivo = rs.getInt("principio_activo_id");
                int unidadMedida = rs.getInt("unidad_medida_id");
                int laboratorio = rs.getInt("laboratorio_id");
                int proveedor = rs.getInt("proveedor_id");
                String presentacion = rs.getString("presentacion");
                Date fechaCaducidad = rs.getDate("fecha_caducidad");
                double valorCompra = rs.getDouble("valor_compra");
                double margenGanancia = rs.getDouble("margen_ganancia");
                int stock = rs.getInt("stock");
                int stockMin = rs.getInt("stock_min");
                int stockMax = rs.getInt("stock_max");
                double valorVenta = rs.getDouble("valor_venta");

                Producto producto = new Producto(codigo,nombreProducto,registroInvima,viaAdministracion,principioActivo,unidadMedida,laboratorio,proveedor,presentacion,fechaCaducidad,valorCompra,margenGanancia,stock,stockMin,stockMax,valorVenta);
                return Optional.of(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    

    @Override
    public void update(Producto producto) {
        String query = "UPDATE producto SET nombre_producto = ?, registro_invima = ?, via_administracion_id = ?, principio_activo_id = ?, unidad_medida_id = ?, laboratorio_id = ?, proveedor_id = ?, presentacion = ?, fecha_caducidad = ?, valor_compra = ?, margen_ganancia = ?, stock = ?, stock_min = ?, stock_max = ? WHERE codigo_producto = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, producto.getNombreProducto());
            statement.setString(2, producto.getRegistroInvima());
            statement.setInt(3, producto.getViaAdministracion());
            statement.setInt(4, producto.getPrincipioActivo());
            statement.setInt(5, producto.getUnidadMedida());
            statement.setInt(6, producto.getLaboratorio());
            statement.setInt(7, producto.getProveedor());
            statement.setString(8, producto.getPresentacion());
            statement.setDate(9, new java.sql.Date(producto.getFechaCaducidad().getTime())); // Usa java.sql.Date para fechas
            statement.setDouble(10, producto.getValorCompra());
            statement.setDouble(11, producto.getMargenGanancia());
            statement.setInt(12, producto.getStock());
            statement.setInt(13, producto.getStockMin());
            statement.setInt(14, producto.getStockMax());
            statement.setString(15, producto.getCodigoProducto());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
}


