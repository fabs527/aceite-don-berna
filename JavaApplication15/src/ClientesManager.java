import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase para manejar operaciones en la tabla "clientes"
public class ClientesManager {

    // Agregar un cliente
    public static void addCliente(String nombre, String telefono, String placa) {
        String insertQuery = "INSERT INTO clientes (nombre, telefono, placa) VALUES (?, ?, ?)";
        try (Connection conn = TestDatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, placa);
            stmt.executeUpdate();
            System.out.println("Cliente agregado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    // Listar todos los clientes
    public static List<String> listClientes() {
        List<String> clientes = new ArrayList<>();
        String selectQuery = "SELECT * FROM clientes";
        try (Connection conn = TestDatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(selectQuery); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String cliente = "ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + 
                                 ", Teléfono: " + rs.getString("telefono") + ", Placa: " + rs.getString("placa");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Actualizar un cliente por ID
    public static void updateCliente(int id, String nombre, String telefono, String placa) {
        String updateQuery = "UPDATE clientes SET nombre = ?, telefono = ?, placa = ? WHERE id = ?";
        try (Connection conn = TestDatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, placa);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    // Eliminar un cliente por ID
    public static void deleteCliente(int id) {
        String deleteQuery = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = TestDatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
}
