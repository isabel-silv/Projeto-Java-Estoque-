/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import data.Produto;
import data.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author csilv
 */
public class ListaProdutos extends javax.swing.JFrame {
 DefaultTableModel Object = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Codigo", "Nome", "Valor", "Quantidade", "Data"});
    public ListaProdutos()  {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        bntConsultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jbtSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Valor", "Quantidade", "Data"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 540, 280);

        bntConsultar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bntConsultar.setText("Pesquisar");
        bntConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(bntConsultar);
        bntConsultar.setBounds(430, 100, 105, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de Produtos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 20, 380, 55);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Serif", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\csilv\\OneDrive\\Documentos\\isabel trabalhos\\PIuc15\\background-rouge-20.jpg")); // NOI18N
        jLabel7.setText("                 Estoque           ");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 10, 480, 70);

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(60, 100, 250, 30);

        jbtSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSair);
        jbtSair.setBounds(450, 450, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/nome-para-loja-de-roupas.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 609, 578);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultarActionPerformed
        this.consulta(txtPesquisar.getText());
    }//GEN-LAST:event_bntConsultarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        CadastrarProduto sair = new CadastrarProduto();
        sair.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed
    @SuppressWarnings("empty-statement")          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtSair;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

  
private void preencherTabela() {   
    ProdutoDAO dao = new ProdutoDAO();
    boolean status = dao.conectar();
    String termoBusca = "";
    if (!status) {
        JOptionPane.showMessageDialog(null, "Erro de conexão");
    } else {
        ArrayList<Produto> listaProduto;
        if (termoBusca.equals("")) {
            listaProduto = dao.BuscarProduto();
        } else {
            listaProduto = dao.buscarProdutoFiltro(termoBusca);
        }

        if (listaProduto != null) {
            DefaultTableModel tabelaProdutos = (DefaultTableModel) tblProdutos.getModel();
            tblProdutos.setRowSorter(new TableRowSorter(tabelaProdutos));
            tabelaProdutos.setNumRows(0);

            for (Produto p : listaProduto) {
                Object[] obj = new Object[]{
                    String.valueOf(p.getId()),
                    p.getNome(),
                    String.valueOf(p.getValor()),
                    String.valueOf(p.getQuantidadeEstoque()),
                    p.getData().toString()
                };
                tabelaProdutos.addRow(obj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.");
        }

        dao.desconectar();
    }


}
public Produto consulta(String nome) {
    ProdutoDAO dao = new ProdutoDAO();
    boolean status = dao.conectar();

    if (status) {
        Produto pro = dao.consulta(nome);

        if (pro == null) {
            JOptionPane.showMessageDialog(null, "Produto não localizado!");
        } else {
            // Faça algo com o produto encontrado (por exemplo, exiba as informações)
            System.out.println("Produto encontrado: " + pro.getNome());
        }

        dao.desconectar();
        return pro;
    } else {
        JOptionPane.showMessageDialog(null, "Erro de conexão");
        return null;
    }
}


    }


   
   
