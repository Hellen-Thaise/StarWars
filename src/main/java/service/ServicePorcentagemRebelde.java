package service;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ServicePorcentagemRebelde {

    static Connection connection = Conexao.getConnection();

    public static void exibirPorcentagemRebelde() {
        try {
            // Consulta para obter os rebeldes
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ROUND(COUNT(CASE WHEN traidor = FALSE THEN id_rebelde END) " +
                    " * 100.0 / COUNT(*),2) AS traidor FROM rebeldes");
            if (resultSet.next()) {
                double rebeldes = resultSet.getDouble("traidor");
                System.out.println("Porcentagem de rebeldes é igual à: " + rebeldes + "%\n");
            }

            // Fechando a conexão com o banco de dados
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao calcular a porcentagem de rebeldes: " + e.getMessage());
        }
    }
}
