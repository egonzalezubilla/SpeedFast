package dao;

import model.Repartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public List<Repartidor> listarTodos() {
        List<Repartidor> listaRepartidores = new ArrayList<>();
        String sql = "SELECT id, nombre FROM repartidor";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                Repartidor repartidor = new Repartidor(id, nombre);

                listaRepartidores.add(repartidor);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo obtener la lista de repartidores: " + e.getMessage());
            e.printStackTrace();
        }

        return listaRepartidores;
    }
}
