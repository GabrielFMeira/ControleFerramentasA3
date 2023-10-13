/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Emprestimo;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.AmigoDAO;
import DAO.EmprestimoDAO;
import Model.Ferramenta;
import DAO.FerramentaDAO;
import Model.Amigo;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class RealizarEmprestimo extends javax.swing.JFrame {

    private Emprestimo objemprestimo; // cria o v�nculo com o emprestimo.java
    private String dataFormat = "dd/MM/yyyy";
    private String separator = "/";

    private void formatarData(javax.swing.JTextField campoData) {
        String texto = campoData.getText();
        int tamanho = texto.length();

        if (tamanho == 2 || tamanho == 5) {
            campoData.setText(texto + "/");
        } else if (tamanho == 10) {
            campoData.setText(texto.substring(0, 9));
        } else if (tamanho > 0 && texto.charAt(tamanho - 1) == separator.charAt(0)) {
            campoData.setText(texto.substring(0, tamanho - 1));
        }
    }

    public RealizarEmprestimo() {

        initComponents();
        this.objemprestimo = new Emprestimo(); // carrega objeto vazio de aluno
        PreencherCbxFerramentas();
        PreencherCbxAmigos();
        setIcon();

        data_devolucao.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                formatarData(data_devolucao);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

    /**
     * Creates new form RealizarEmprestimo
     */
    private void PreencherCbxFerramentas() {

        FerramentaDAO objferramenta = new FerramentaDAO();
        ArrayList<Ferramenta> listaCbxFerramentas = objferramenta.getListaFerramentas();
        cbxFerramenta.removeAllItems();

        for (int i = 0; i < listaCbxFerramentas.size(); i++) {
            cbxFerramenta.addItem(listaCbxFerramentas.get(i).getNome());
        }
    }

    private void PreencherCbxAmigos() {

        AmigoDAO objamigo = new AmigoDAO();
        ArrayList<Amigo> listaCbxAmigos = objamigo.getListaAmigos();
        cbxAmigos.removeAllItems();

        for (int i = 0; i < listaCbxAmigos.size(); i++) {
            cbxAmigos.addItem(listaCbxAmigos.get(i).getNome());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RealizarEmprestimo = new javax.swing.JButton();
        cbxFerramenta = new javax.swing.JComboBox();
        cbxAmigos = new javax.swing.JComboBox();
        data_devolucao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Montserrat", 2, 14)); // NOI18N
        jLabel1.setText("Selecione uma ferramenta:");

        jLabel2.setFont(new java.awt.Font("Montserrat", 2, 14)); // NOI18N
        jLabel2.setText("Selecione um amigo:");

        RealizarEmprestimo.setText("SALVAR");
        RealizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarEmprestimoActionPerformed(evt);
            }
        });

        cbxFerramenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxFerramenta.setToolTipText("");
        cbxFerramenta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxFerramentaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFerramentaActionPerformed(evt);
            }
        });

        cbxAmigos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxAmigos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxAmigosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAmigosActionPerformed(evt);
            }
        });

        data_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_devolucaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 2, 14)); // NOI18N
        jLabel5.setText("Data de devolução:");

        jLabel4.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel4.setText("Realizar Empréstimo");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo clean code1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(data_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(RealizarEmprestimo)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(data_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(RealizarEmprestimo)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RealizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarEmprestimoActionPerformed

        try {

            // recebendo e validando dados da interface gr�fica.
            int ferramenta_id = cbxFerramenta.getSelectedIndex() + 1;
            int amigo_id = cbxAmigos.getSelectedIndex() + 1;

            // Obtendo a data atual
            Date dataAtual = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String data_emprestimo = formatador.format(dataAtual);
            String data_devolucao = this.data_devolucao.getText();
            
            // Verificar se a ferramenta já está emprestada
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            if (emprestimoDAO.verificarFerramentaEmprestada(ferramenta_id)) {
                JOptionPane.showMessageDialog(rootPane, "Essa ferramenta já está emprestada!");
                return;
            }
            if (ferramenta_id == -1 || amigo_id == -1 || data_devolucao.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos obrigatórios!");
                return;
            }

            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date emprestimoDate = null;

            if (!data_emprestimo.isEmpty()) {
                emprestimoDate = inputFormat.parse(data_emprestimo);
            }

            if (emprestimoDate != null) {
                String emprestimoFormatted = outputFormat.format(emprestimoDate);
                Date devolucaoDate = inputFormat.parse(data_devolucao);
                String devolucaoFormatted = outputFormat.format(devolucaoDate);

                // Envia os dados para o Controlador cadastrar
                if (this.objemprestimo.CadastrarEmprestimoBD(ferramenta_id, amigo_id, emprestimoFormatted, devolucaoFormatted)) {
                    JOptionPane.showMessageDialog(rootPane, "Empréstimo realizado com sucesso!");

                    // Limpa campos da interface
                   
                    this.data_devolucao.setText("");

                    System.out.println(this.objemprestimo.getListaEmprestimos().toString());

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Preencha corretamente a data de empréstimo!");
            }
        } catch (ParseException ex) {
            Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (Mensagens1 erro) {
//            JOptionPane.showMessageDialog(null, erro.getMessage());
//        }  catch (SQLException ex) {
//           Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
//       }

//        } catch (Mensagens1 erro) {
//            JOptionPane.showMessageDialog(null, erro.getMessage());
//        }  catch (SQLException ex) {
//           Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
//       }

    }//GEN-LAST:event_RealizarEmprestimoActionPerformed

    private void cbxFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFerramentaActionPerformed


    }//GEN-LAST:event_cbxFerramentaActionPerformed

    private void cbxAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAmigosActionPerformed

    }//GEN-LAST:event_cbxAmigosActionPerformed

    private void cbxFerramentaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxFerramentaAncestorAdded
//        FerramentaDAO objferramenta = new FerramentaDAO();
//        ArrayList<Ferramenta> listaCbxFerramentas = objferramenta.getListaFerramentas();
//        cbxFerramenta.removeAllItems();
//
//        for (Ferramenta f : listaCbxFerramentas) {
//            cbxFerramenta.addItem(f);
//        }
    }//GEN-LAST:event_cbxFerramentaAncestorAdded

    private void cbxAmigosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxAmigosAncestorAdded
//        AmigoDAO objamigo = new AmigoDAO();
//        ArrayList<Amigo> listaCbxAmigos = objamigo.getListaAmigos();
//        cbxAmigos.removeAllItems();
//        
//        for (Amigo f : listaCbxAmigos) {
//            cbxAmigos.addItem(f);
//        }
    }//GEN-LAST:event_cbxAmigosAncestorAdded

    private void data_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_devolucaoActionPerformed

    }//GEN-LAST:event_data_devolucaoActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RealizarEmprestimo;
    private javax.swing.JComboBox cbxAmigos;
    private javax.swing.JComboBox cbxFerramenta;
    private javax.swing.JTextField data_devolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo clean code1.png")));
    }
}
