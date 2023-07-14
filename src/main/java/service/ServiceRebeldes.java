package service;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceRebeldes {
    static Connection connection = Conexao.getConnection();

    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultarRegistros(){
        String sql = "select * from rebeldes";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(
                        "\n id: "+ resultSet.getInt("id_rebelde")
                        + "\n nome: "+ resultSet.getString("nome_rebelde")
                        + "\n idade: "+ resultSet.getString("idade")
                        + "\n gênero: "+ resultSet.getString("genero")
                        + "\n localização: "+ resultSet.getString("localizacao"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void inserirRegistro(String nome, Integer idade, String genero, String localizacao){
        String sql = String.format("insert into rebeldes(nome_rebelde, idade, genero, localizacao) values ('%s', %d, '%s','%s');",nome, idade, genero, localizacao);
        try {
            statement.executeUpdate(sql);
            System.out.println("Inserção feita com sucesso.\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarRegistro(Integer id_rebelde, String localizacao){

        try{
            String sql = String.format("update rebeldes set localizacao='%s' where id_rebelde=%d;",localizacao, id_rebelde);
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Realizada alteração\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inserirRegistro(String nomeRebelde) {
    }
}
