import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase para conectar a la base de datos MySQL
public class TestDatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/nueva_base_datos";  // URL de conexión (cambia por tu base de datos)
    private static final String DB_USER = "root";  // Usuario de MySQL
    private static final String DB_PASSWORD = "sena1234";  // Contraseña de MySQL

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        // Intentar conectar a la base de datos
        try (Connection conn = getConnection()) {
            System.out.println("Conexión exitosa a la base de datos.");  // Mensaje si la conexión es exitosa
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());  // Manejo de errores
        }
    }
}
