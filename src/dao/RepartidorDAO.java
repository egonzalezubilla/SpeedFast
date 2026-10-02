package dao;

import model.Repartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class RepartidorDAO {

    /**
     * Registra un nuevo repartidor en la base de datos (Operación CREATE).
     * El ID se genera automaticamente en la BD por ser AUTO_INCREMENT.
     */
    public void guardar(Repartidor repartidor) {
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, repartidor.getNombre());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    repartidor.setId(generatedKeys.getInt(1));
                }
            }

            System.out.println("[Base de Datos] Repartidor guardado con exito: " + repartidor.getNombre() + " (ID: " + repartidor.getId() + ")");

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo guardar el repartidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la lista completa de repartidores (Operación READ).
     */
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

    /**
     * Actualiza el nombre de un repartidor existente en la base de datos
     * (Operación UPDATE).
     */
    public void actualizarRegistro(int idRepartidor, String nuevoNombre) {
        String sql = "UPDATE repartidor SET nombre = ? WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, idRepartidor);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("[Base de Datos] Repartidor con ID " + idRepartidor + " actualizado exitosamente a: " + nuevoNombre);
            } else {
                System.out.println("[Base de Datos] No se encontro un repartidor con el ID " + idRepartidor);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo actualizar el repartidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Elimina un repartidor de la base de datos según su ID (Operación DELETE).
     */
    public void eliminarRegistro(int idRepartidor) {
        String sql = "DELETE FROM repartidor WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idRepartidor);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("[Base de Datos] Repartidor con ID " + idRepartidor + " eliminado con exito.");
            } else {
                System.out.println("[Base de Datos] No se encontro ningun repartidor con el ID " + idRepartidor);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo eliminar el repartidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
