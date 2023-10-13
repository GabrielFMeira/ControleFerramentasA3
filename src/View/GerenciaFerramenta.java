package View;

import Model.Ferramenta;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciaFerramenta extends javax.swing.JFrame {

    private Ferramenta objFerramenta; // cria o v�nculo com o objaluno

    public GerenciaFerramenta() {
        initComponents();
        this.objFerramenta = new Ferramenta(); // carrega objaluno de aluno
        this.carregaTabela();
        setIcon();
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
        jTableFerramentas = new javax.swing.JTable();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_marca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_custo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Gerenciamento de Ferramentas");
        setResizable(false);

        jTableFerramentas.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Custo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFerramentas);
        if (jTableFerramentas.getColumnModel().getColumnCount() > 0) {
            jTableFerramentas.getColumnModel().getColumn(0).setMinWidth(30);
            jTableFerramentas.getColumnModel().getColumn(1).setMinWidth(200);
            jTableFerramentas.getColumnModel().getColumn(2).setMinWidth(100);
        }

        b_cancelar.setFont(new java.awt.Font("Montserrat", 2, 10)); // NOI18N
        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_alterar.setFont(new java.awt.Font("Montserrat", 2, 10)); // NOI18N
        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setFont(new java.awt.Font("Montserrat", 2, 10)); // NOI18N
        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jLabel1.setText("Nome:");

        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jLabel4.setText("Custo:");

        jLabel5.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel5.setText("Gerenciar Ferramentas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo clean code1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_custo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_apagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(b_alterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(b_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_alterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_apagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_custo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed

       try {
            // recebendo e validando dados da interface gr�fica.
            
            int id = 0;
            String nome = "";
  
            String marca = "";
            
            String custo ="";
  

            if (this.c_nome.getText().length() < 2) {
                throw new Mensagens1("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.c_nome.getText();
            }
            
            if (this.c_marca.getText().length() < 2) {
                throw new Mensagens1("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca  = this.c_marca.getText();
            }
            
            
             if (this.c_custo.getText().length() < 2) {
                throw new Mensagens1("Custo deve conter ao menos 2 caracteres.");
            } else {
                custo  = this.c_custo.getText();
            }
             
            if (this.jTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagens1("Primeiro Selecione uma ferramenta para Alterar");
            } else {
                id = Integer.parseInt(this.jTableFerramentas.getValueAt(this.jTableFerramentas.getSelectedRow(), 0).toString());
            }

            // envia os dados para o Aluno processar
            if (this.objFerramenta.AtualizarFerramentaBD(nome, marca,id,custo )) {

                // limpa os campos
                this.c_nome.setText("");
           
                this.c_marca.setText("");
                
                this.c_custo.setText("");
           
                JOptionPane.showMessageDialog(rootPane, "Ferramenta Alterada com Sucesso!");

            }
            System.out.println(this.objFerramenta.getListaFerramentas().toString());
        } catch (Mensagens1 erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_b_alterarActionPerformed

    private void jTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFerramentasMouseClicked

        if (this.jTableFerramentas.getSelectedRow() != -1) {

            String nome = this.jTableFerramentas.getValueAt(this.jTableFerramentas.getSelectedRow(), 1).toString();
            String marca = this.jTableFerramentas.getValueAt(this.jTableFerramentas.getSelectedRow(), 2).toString();
            String custo = this.jTableFerramentas.getValueAt(this.jTableFerramentas.getSelectedRow(), 3).toString();
    
            this.c_nome.setText(nome);
           
            this.c_marca.setText(marca);
            
            this.c_custo.setText(custo);
        }
    }//GEN-LAST:event_jTableFerramentasMouseClicked

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed
        try {
            // validando dados da interface gr�fica.
            int id = 0;
            if (this.jTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagens1("Primeiro Selecione uma ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableFerramentas.getValueAt(this.jTableFerramentas.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro bot�o
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Amigo ?");

            if (resposta_usuario == 0) {// clicou em SIM

                // envia os dados para o Aluno processar
                if (this.objFerramenta.ExcluirFerramentaBD(id)) {

                    // limpa os campos
                    this.c_nome.setText("");
              
                    this.c_marca.setText("");
                    
                    this.c_custo.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta Apagada com Sucesso!");

                }

            }

            System.out.println(this.objFerramenta.getListaFerramentas().toString());

        } catch (Mensagens1 erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_b_apagarActionPerformed

    private void c_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTableFerramentas.getModel();
        modelo.setNumRows(0);

        ArrayList<Ferramenta> minhalista = new ArrayList<>();
        minhalista = objFerramenta.getListaFerramentas();

        for (Ferramenta a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getMarca(),
                 a.getCusto(),
               
            });
        }
    }

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
            java.util.logging.Logger.getLogger(GerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaFerramenta().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_custo;
    private javax.swing.JTextField c_marca;
    private javax.swing.JTextField c_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFerramentas;
    // End of variables declaration//GEN-END:variables

    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo clean code1.png")));
    }
}