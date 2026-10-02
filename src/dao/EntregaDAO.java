package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    /**
     * Registra una nueva entrega asociando un pedido y un repartidor,
     * registrando automáticamente la fecha y hora actuales (Operación CREATE).
     *
     * @param idPedido Identificador del pedido a entregar.
     * @param idRepartidor Identificador del repartidor asignado.
     */
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

    /**
     * Obtiene la lista de todas las entregas registradas en la base de datos
     * (Operación READ).
     *
     * @return Una lista con arreglos o un objeto mapeado con los datos de las
     * entregas.
     */
    public List<String> listarTodosFormateado() {
        List<String> listaEntregas = new ArrayList<>();
        String sql = "SELECT e.id, p.direccion, r.nombre, e.fecha, e.hora "
                + "FROM entrega e "
                + "JOIN pedido p ON e.id_pedido = p.id "
                + "JOIN repartidor r ON e.id_repartidor = r.id";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                String repartidor = rs.getString("nombre");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");

                String info = "ID Entrega: " + id + " | Pedido: " + direccion + " | Repartidor: " + repartidor + " | Fecha: " + fecha + " " + hora;
                listaEntregas.add(info);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo listar las entregas: " + e.getMessage());
            e.printStackTrace();
        }

        return listaEntregas;
    }

    /**
     * Actualiza la asociación de una entrega existente (Operación UPDATE).
     * Permite reasignar el pedido o el repartidor, actualizando la fecha y
     * hora.
     *
     * @param idEntrega Identificador de la entrega a modificar.
     * @param nuevoIdPedido Nuevo ID de pedido asociado.
     * @param nuevoIdRepartidor Nuevo ID de repartidor asociado.
     */
    public void actualizarRegistro(int idEntrega, int nuevoIdPedido, int nuevoIdRepartidor) {
        String sql = "UPDATE entrega SET id_pedido = ?, id_repartidor = ?, fecha = ?, hora = ? WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, nuevoIdPedido);
            pstmt.setInt(2, nuevoIdRepartidor);
            pstmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.setTime(4, java.sql.Time.valueOf(LocalTime.now()));
            pstmt.setInt(5, idEntrega);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("[Base de Datos] Entrega ID " + idEntrega + " actualizada con éxito.");
            } else {
                System.out.println("[Base de Datos] No se encontró ninguna entrega con el ID " + idEntrega);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo actualizar la entrega: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Elimina un registro de entrega de la base de datos según su ID (Operación
     * DELETE).
     *
     * @param idEntrega Identificador de la entrega a eliminar.
     */
    public boolean eliminarRegistro(int idEntrega) {
        String sql = "DELETE FROM entrega WHERE id = ?";
        boolean eliminado = false;

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idEntrega);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("[Base de Datos] Entrega ID " + idEntrega + " eliminada con éxito.");
                eliminado = true;
            } else {
                System.out.println("[Base de Datos] No se encontró ninguna entrega con el ID " + idEntrega);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo eliminar la entrega: " + e.getMessage());
            e.printStackTrace();
        }

        return eliminado;
    }
    
    /**
     * Obtiene la lista de entregas formateada en arreglos para ser mostrada en JTable.
     */
    public List<Object[]> listarParaTabla() {
        List<Object[]> lista = new ArrayList<>();
        // Agregamos p.estado al SELECT
        String sql = "SELECT e.id, p.direccion, r.nombre, e.fecha, e.hora, p.estado "
                + "FROM entrega e "
                + "JOIN pedido p ON e.id_pedido = p.id "
                + "JOIN repartidor r ON e.id_repartidor = r.id";

        try (Connection conexion = ConexionDB.conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("direccion"),
                    rs.getString("nombre"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("estado") // Incluimos el estado aquí
                };
                lista.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("[Error DAO] No se pudo listar las entregas para la tabla: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
