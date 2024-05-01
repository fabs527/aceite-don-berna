import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;  // Para conexión a la base de datos
import java.sql.PreparedStatement;  // Para consultas preparadas
import java.sql.SQLException;  // Para manejar excepciones SQL

@WebServlet("/AgregarClienteServlet")  // Ruta para el servlet
public class AgregarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obtener los datos del formulario
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));  // Conversión de cadena a número
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String placa = request.getParameter("placa");

        // Conexión a la base de datos
        try (Connection conn = TestDatabaseConnection2.getConnection()) {
            String insertQuery = "INSERT INTO clientes (id, nombre, telefono, placa) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {  // Consulta para insertar datos
                stmt.setInt(1, cliente_id);  // Asignar el ID
                stmt.setString(2, nombre);
                stmt.setString(3, telefono);
                stmt.setString(4, placa);  // Asignar la placa
                stmt.executeUpdate();  // Ejecutar la consulta
                response.getWriter().println("Cliente agregado exitosamente.");
            }
        } catch (SQLException e) {  // Manejo de errores SQL
            response.getWriter().println("Error al agregar cliente: " + e.getMessage());
        }
    }
}
