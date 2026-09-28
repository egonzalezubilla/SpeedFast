package dao;

import model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public int guardar(Pedido pedido) {
        String sql = "INSERT INTO pedido (direccion, tipo, descripcion, estado) VALUES (?, ?, ?, ?)";
        int idGenerado = -1;

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pedido.getDireccionPedido());
            pstmt.setString(2, pedido.getTipoPedido());
            pstmt.setString(3, pedido.getDescripcion());
            pstmt.setString(4, pedido.getEstado().name());

            pstmt.executeUpdate();

            try (var generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idGenerado = generatedKeys.getInt(1);
                    pedido.setId(idGenerado);
                }
            }
            System.out.println("[Base de Datos] Pedido guardado con ID: " + idGenerado);

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo guardar el pedido: " + e.getMessage());
            e.printStackTrace();
        }

        return idGenerado;
    }

    public java.util.List<model.Pedido> listarTodos() {
        java.util.List<model.Pedido> listaPedidos = new java.util.ArrayList<>();
        String sql = "SELECT id, direccion, tipo, descripcion, estado FROM pedido";

        try (java.sql.Connection conexion = ConexionDB.conectar(); java.sql.PreparedStatement pstmt = conexion.prepareStatement(sql); java.sql.ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String estadoStr = rs.getString("estado");

                model.EstadoPedido estado = null;
                if (estadoStr != null && !estadoStr.isEmpty()) {
                    try {
                        estado = model.EstadoPedido.valueOf(estadoStr);
                    } catch (IllegalArgumentException e) {
                        estado = null;
                    }
                }

                model.Pedido pedido = null;

                switch (tipo) {
                    case "Pedido Comida":
                        pedido = new model.PedidoComida(id, tipo, descripcion, direccion, 0.0, 0.0, estado);
                        break;
                    case "Pedido Encomienda":
                        pedido = new model.PedidoEncomienda(id, tipo, descripcion, direccion, 0.0, 0.0, estado);
                        break;
                    case "Pedido Express":
                        pedido = new model.PedidoExpress(id, tipo, descripcion, direccion, 0.0, 0.0, estado);
                        break;
                    default:
                        pedido = new model.PedidoComida(id, tipo, descripcion, direccion, 0.0, 0.0, estado);
                        break;
                }

                listaPedidos.add(pedido);
            }

        } catch (java.sql.SQLException e) {
            System.err.println("[Error DAO] No se pudo listar los pedidos: " + e.getMessage());
            e.printStackTrace();
        }

        return listaPedidos;
    }

    public void actualizarEstado(int idPedido, String nuevoEstado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nuevoEstado);
            pstmt.setInt(2, idPedido);
            pstmt.executeUpdate();

            System.out.println("[Base de Datos] Estado del pedido ID " + idPedido + " actualizado a: " + nuevoEstado);

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo actualizar el estado: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
