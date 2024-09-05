package data;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AplicacaoAcessoBd {
    
    public static void main(String[] args) { 
        Conexao conector = new Conexao();
        
        conector.getConexao();
    try {
            Connection conn; 
            Statement st; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi","root","Jkic25032004@");
             st = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("O Driver não está disponível na biblioteca");
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida ");
        }
}
}
