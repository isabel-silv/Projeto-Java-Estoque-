package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        Connection conn;
    
    public String url = "jdbc:mysql://localhost:3306/pi";
    public String user = "root"; 
    public String password = "Jkic25032004@"; 
     
     public Connection getConexao() {
         Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi","root","Jkic25032004@");
            System.out.println("Conexão realizada com sucesso");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco" +" "+ ex.getMessage());
            return null;
    }
    }
    
        public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
        
    }
        }
}

