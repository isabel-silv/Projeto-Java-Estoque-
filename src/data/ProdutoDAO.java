
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    private Conexao conexao;
    private Connection conn;

    public boolean conectar() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        return this.conn != null;
    }

  public boolean salvar(Produto pro) {
    boolean status = false; 

    try (PreparedStatement st = conn.prepareStatement("INSERT INTO produto (id, nome, valor, quantidadeEstoque, data) VALUES (?,?,?,?,?)")) {
        st.setInt(1, pro.getId());
        st.setString(2, pro.getNome());
        st.setDouble(3, pro.getValor());
        st.setInt(4, pro.getQuantidadeEstoque());
        st.setDate(5, (Date) pro.getData());
        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
            status = true;
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao salvar o produto: " + ex.getMessage());
    }

    return status;

  }

    public int atualizar(Produto pro) {

        int status;

        try {
 PreparedStatement st = conn.prepareStatement("UPDATE produto SET  nome=?, valor=?, quantidadeEstoque=?, data=? WHERE id=?");
   
   st.setString(1, pro.getNome());
   st.setDouble(2, pro.getValor());
   st.setInt(3, pro.getQuantidadeEstoque());
   st.setDate(4, (Date) pro.getData()); 
   st.setInt(5, pro.getId());
   status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return ex.getErrorCode();
        }
    }


    public ArrayList<Produto> BuscarProduto () {
     ResultSet rs; 
     ArrayList<Produto> produto = new ArrayList<>();
    try {
        Conexao conecta = new Conexao();
        Connection conn = conexao.getConexao();
        String sqlFiltro = "SELECT * FROM produto";
        PreparedStatement st = conn.prepareStatement(sqlFiltro);
     
          rs = st.executeQuery();
    
         
        while (rs.next()) {
    
            Produto pro = new Produto();
                pro.setId(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setValor(rs.getDouble("valor"));
                pro.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                pro.setData(rs.getDate("data"));  
                
                produto.add(pro);
        }
        return produto;
        }catch (SQLException ex) {
        System.out.println("Erro ao conectar " + ex.getMessage());
        return null;
       
    }
    }
    
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM produto WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return false;
        }
    }

 

    public ArrayList<Produto> buscarProdutoFiltro(String query) {
    ResultSet rs;
    try {
      Conexao conecta = new Conexao();
        Connection conn = conexao.getConexao();
        String sql = "SELECT * FROM produto" + query;

        if (this.conn == null) {
            throw new SQLException("Conexão não inicializada.");
        }

        PreparedStatement st = conn.prepareStatement(sql);
        rs = st.executeQuery();
         ArrayList<Produto> produto = new ArrayList<>();
        while (rs.next()) {
            Produto pro = new Produto();
            pro.setId(rs.getInt("id"));
            pro.setNome(rs.getString("nome"));
            pro.setValor(rs.getDouble("valor"));
            pro.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
            pro.setData(rs.getDate("data"));
            produto.add(pro);
        }
        return produto;
    } catch (SQLException ex) {
        System.out.println("Erro ao buscar dados do Banco! " + ex.getMessage());
        return null;
    }
}
public Produto consulta(String nome) {
    try {
        Produto ProdutoEncontrado = new Produto();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM produto WHERE nome = ?");
        st.setString(1, nome);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            ProdutoEncontrado.setId(rs.getInt("id"));
            ProdutoEncontrado.setNome(rs.getString("nome"));
            ProdutoEncontrado.setValor(rs.getDouble("valor"));
            ProdutoEncontrado.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
            ProdutoEncontrado.setData(rs.getDate("data"));

            // Exibe a mensagem com os dados do produto encontrado
            JOptionPane.showMessageDialog(null, """
                                                Produto encontrado:
                                                ID: """ + ProdutoEncontrado.getId() + "\n" +
                    "Nome: " + ProdutoEncontrado.getNome() + "\n" +
                    "Valor: " + ProdutoEncontrado.getValor() + "\n" +
                    "Estoque: " + ProdutoEncontrado.getQuantidadeEstoque() + "\n" +
                    "Data: " + ProdutoEncontrado.getData());

            return ProdutoEncontrado;
        } else {
            JOptionPane.showMessageDialog(null, "Produto não localizado!");
            return null;
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao conectar " + ex.getMessage());
        return null;
    }
 }
public Produto consultaPorId(int id) {
        Produto produto = null;
        boolean status = conectar();
        if (status) {
            String sql = "SELECT * FROM produtos WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setValor(rs.getDouble("valor"));
                    produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                    produto.setData(rs.getDate("data"));
                }
            } catch (SQLException e) {
            } finally {
                desconectar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        return produto;
    }



 public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.print("erro ao desconectar " + ex.getMessage());
        }
 }
}
        
  


