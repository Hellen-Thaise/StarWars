package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
            public static java.sql.Connection getConnection() {
            try {
                java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/starwars",
                        "postgres", "1234");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

}
