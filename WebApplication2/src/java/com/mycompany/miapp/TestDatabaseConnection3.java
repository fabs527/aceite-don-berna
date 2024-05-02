package com.mycompany.miapp;  // Asegúrate de que el nombre del paquete sea correcto

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase para manejar conexiones a la base de datos MySQL
public class TestDatabaseConnection3 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/nueva_base_datos";  // Cambia al nombre de tu base de datos
    private static final String DB_USER = "root";  // Usuario de MySQL
    private static final String DB_PASSWORD = "sena1234";  // Contraseña de MySQL

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

adsadasdsadsadsdssad