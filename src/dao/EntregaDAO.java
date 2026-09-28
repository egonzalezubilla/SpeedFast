package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EntregaDAO {

    public void guardar(int idPedido, int idRepartidor) {
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, idRepartidor);
            pstmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.setTime(4, java.sql.Time.valueOf(LocalTime.now()));

            pstmt.executeUpdate();
            System.out.println("[Base de Datos] Entrega vinculada y guardada con éxito.");

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo registrar la entrega: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
