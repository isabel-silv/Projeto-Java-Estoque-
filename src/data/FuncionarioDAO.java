/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author csilv
 */
public class FuncionarioDAO {
     private Conexao conexao;
    private Connection conn;

    public boolean conectar() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
         return this.conn != null;
    }
      public int salvar(Funcionario func) {

        int status;

        try {
            //colocar as minhas instrucoes do metodo
            PreparedStatement st = conn.prepareStatement("INSERT INTO funcionario (usuario, senha, id_permissao) VALUES (?,?,?)");
            st.setString(1, func.getUsuario());
            st.setString(2, func.getSenha());
            st.setInt(3, func.getId_permissao());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            return ex.getErrorCode();
        }
    }
     public Funcionario consulta(String usuario) {

        try {
            Funcionario funcionarioEncontrado = new Funcionario();
            PreparedStatement st = conn.prepareStatement("SELECT * from funcionario WHERE usuario = ?");
            st.setString(1, usuario);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                //obter os dados do banco
                funcionarioEncontrado.setUsuario(rs.getString("usuario"));
                funcionarioEncontrado.setSenha(rs.getString("senha"));
                funcionarioEncontrado.setId_permissao(rs.getInt("id_permissao"));   
                return funcionarioEncontrado;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }

    }
      public List<Funcionario> listagem(String termoBusca) {

        try {

            //crio um objeto de listagem
            List<Funcionario> lista = new ArrayList<>();

            //preparo o SQL de consulta
            String sqlFiltro = "SELECT * from funcionario = id) ";
            if (!termoBusca.isEmpty()) {
                //caso o termoBusca tenha sido informado
                sqlFiltro = sqlFiltro + " WHERE usuario like ?";
            }

            //disparar a consulta no banco de dados
            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if (!termoBusca.isEmpty()) {
                //caso o termoBusca tenha sido informado
                st.setString(1, "%" + termoBusca + "%");
            }

            //armazenar o resultado da pesquisa
            ResultSet rs = st.executeQuery();

            //por ser uma lista usamos o WHILE
            while (rs.next()) {
                //criar um objeto de funcionario individual
                Funcionario funcionarioEncontrado = new Funcionario();
                 funcionarioEncontrado.setUsuario(rs.getString("usuario"));
                funcionarioEncontrado.setSenha(rs.getString("senha"));
                funcionarioEncontrado.setId_permissao(rs.getInt("id_permissao"));   
            
                lista.add(funcionarioEncontrado);
            }

            //retornar a listagem 
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }

    }     
 public boolean excluir(String usuario) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM funcionario WHERE usuario = ?");
            st.setString(1, usuario);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return false;
        }
    }
 public int atualizar(Funcionario func) {

        int status;

        try {
            PreparedStatement st = conn.prepareStatement("UPDATE funcionario SET usuario=?, senha=? WHERE id_permissao=?");
             st.setString(1, func.getUsuario());
            st.setString(2, func.getSenha());
            st.setInt(3, func.getId_permissao());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.print("erro ao desconectar " + ex.getMessage());
        }
    }

            
            }


