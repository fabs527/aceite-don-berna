<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Agregarfdfddfd Cliente</title>
</head>
<body>
    <h1>Formulario para Agregar Cliente</h1>
    <form action="/AgregarClienteServlet" method="post">  <!-- Envío de datos al servlet -->
        ID: <input type="number" name="cliente_id" required><br>  <!-- Campo para ID -->
        Nombre: <input type="text" name="nombre" required><br>  <!-- Campo para nombre -->
        Teléfono: <input type="text" name="telefono" required><br>  <!-- Campo para teléfono -->
        Placa: <input type="text" name="placa" required><br>  <!-- Campo para placa -->
        <button type="submit">Agregar Cliente</button>
    </form>
</body>
</html>
