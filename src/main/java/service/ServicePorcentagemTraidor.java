package service;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicePorcentagemTraidor {
    static Connection connection = Conexao.getConnection();

    public static void exibirPorcentagemTraidor() {
        try {
            // Consulta para obter os rebeldes
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ROUND(COUNT(CASE WHEN traidor = TRUE THEN id_rebelde END) " +
                    " * 100.0 / COUNT(*),2) AS traidor FROM rebeldes");
            if (resultSet.next()) {
                double traidor = resultSet.getDouble("traidor");
                System.out.println("Porcentagem de traidores é de: " + traidor + "%");
            }
            // Fechando a conexão com o banco de dados
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao calcular a porcentagem de traidores: " + e.getMessage());
        }
    }
}
