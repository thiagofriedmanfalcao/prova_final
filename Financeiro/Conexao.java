package Financeiro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {
    public static Connection getConnection() throws Exception {
        try {
            final String url = "jdbc:mysql://localhost:3306/contas?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertPeople(
        Connection conexao,
        int idPessoa, 
        String nome, 
        String email
    ) throws Exception {
        String sql = "INSERT INTO pessoas " + 
                        "(id, nome, email) " + 
                    "VALUES(?,?,?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, idPessoa);
            statement.setString(2, nome);
            statement.setString(3, email);
            
            statement.execute();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void insertDebt(
        Connection conexao,
        int idDivida, 
        int ano,
        int mes,          
        Double valor,
        double percentual_desconto,
        int pessoas_id
    ) throws Exception {
        String sql = "INSERT INTO dividas " + 
                        "(id, ano, mes, valor, percentual_desconto, pessoas_id) " + 
                    "VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, idDivida);
            statement.setInt(2, ano);
            statement.setInt(3, mes);
            statement.setDouble(4, valor);
            statement.setDouble(5, percentual_desconto);
            statement.setInt(6, pessoas_id);                        
            
            statement.execute();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void insertSalary(
        Connection conexao,
        int idProvento,
        int ano,
        int mes,
        Double valor,
        double imposto,
        int pessoas_id
    ) throws Exception {
        String sql = "INSERT INTO proventos " + 
                        "(id, ano, mes, valor, imposto, pessoas_id) " + 
                    "VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, idProvento);
            statement.setInt(2, ano);
            statement.setInt(3, mes);
            statement.setDouble(4, valor);
            statement.setDouble(5, imposto);
            statement.setInt(6, pessoas_id);                        
            
            statement.execute();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public static void findPeople(Connection conexao) throws Exception {
        String sql = "SELECT * FROM pessoas";
        Statement statemente = conexao.createStatement();
        ResultSet resultados = statemente.executeQuery(sql);

        while(resultados.next()){
            Pessoas pessoa = new Pessoas(
                resultados.getInt("id"),
                resultados.getString("nome"),
                resultados.getString("email")
            );

            System.out.println(pessoa);
        }  
    } 

}