package service;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceReportarTraidor {

        static Connection connection = Conexao.getConnection();
        public static void serviceReportarTraidor() {
            int id;
            Scanner entrada = new Scanner(System.in);

            System.out.println("ID do Rebelde: ");
            id = entrada.nextInt();

            //Verificar existência do rebelde
            try {
                PreparedStatement selectStatment = connection.prepareStatement("SELECT * FROM rebeldes WHERE id_rebelde= ?");
                selectStatment.setInt(1, id);
                ResultSet resultSet = selectStatment.executeQuery();

                if (resultSet.next()) {
                    int reportar = resultSet.getInt("reportar");
                    reportar++;

                    //Atualizar número de reportes
                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE rebeldes SET traidor = true WHERE id_rebelde=?");
                    updateStatement.setInt(1, reportar);
                    updateStatement.setInt(1, id);
                    updateStatement.executeUpdate();

                    //Marcar rebelde como traidor
                    if (reportar >= 3) {
                        PreparedStatement markTraidorStatement = connection.prepareStatement("UPDATE rebeldes set traidor = true WHERE id_rebelde=?");
                        markTraidorStatement.setInt(1, id);
                        markTraidorStatement.executeUpdate();
                        System.out.println("Rebelde marcado como traidor!");

                    } else {
                        System.out.println("Traidor Reportado.");
                    }
                } else {
                    System.out.println("Nenhum rebelde com este ID foi encontrado.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao reportar o rebelde: " + e.getMessage());
            }
        }

}
