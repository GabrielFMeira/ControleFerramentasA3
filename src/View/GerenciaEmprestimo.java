package View;

import DAO.AmigoDAO;
import DAO.FerramentaDAO;
import Model.Emprestimo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Ferramenta;
import Model.Amigo;
import java.awt.Toolkit;

public class GerenciaEmprestimo extends javax.swing.JFrame {

    private Emprestimo objEmprestimo; // cria o v�nculo com o objemprestimo
    private String dataFormat = "dd/MM/yyyy";
    private String separator = "/";
    
 private Ferramenta getFerramentaPorId(int ferramentaId) {
    FerramentaDAO objFerramenta = new FerramentaDAO();
    ArrayList<Ferramenta> listaFerramentas = objFerramenta.getListaFerramentas();

    for (Ferramenta ferramenta : listaFerramentas) {
        if (ferramenta.getId() == ferramentaId) {
            return ferramenta;
        }
    }

    return null;
}

private Amigo getAmigoPorId(int amigoId) {
    AmigoDAO objAmigo = new AmigoDAO();
    ArrayList<Amigo> listaAmigos = objAmigo.getListaAmigos();

    for (Amigo amigo : listaAmigos) {
        if (amigo.getId() == amigoId) {
            return amigo;
        }
    }

    return null;
}
    private String converterData(String data) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(data);
            return outputFormat.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

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

    public GerenciaEmprestimo() {
        initComponents();
        this.objEmprestimo = new Emprestimo();
        this.carregaTabela();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        data_devolucao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Gerenciamento de Ferramentas");
        setResizable(false);

        jTableEmprestimos.setFont(new java.awt.Font("Montserrat", 2, 12)); // NOI18N
        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Amigo", "Data_emprestimo", "Data_devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmprestimos);

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
        jLabel1.setText("Data_devolução:");

        data_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_devolucaoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 2, 18)); // NOI18N
        jLabel4.setText("Gerenciar Empréstimos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo clean code1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_alterar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar)
                    .addComponent(data_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_apagar)
                .addGap(16, 31, Short.MAX_VALUE))
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
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String data_devolucao = "";

            data_devolucao = this.data_devolucao.getText();
            if (this.jTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagens1("Primeiro Selecione um Emprestimo para Alterar");
            } else {
                id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
            }
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date emprestimoDate = null;

            if (!data_devolucao.isEmpty()) {
                emprestimoDate = inputFormat.parse(data_devolucao);
            }

            if (emprestimoDate != null) {
                String emprestimoFormatted = outputFormat.format(emprestimoDate);
                Date devolucaoDate = inputFormat.parse(data_devolucao);
                String devolucaoFormatted = outputFormat.format(devolucaoDate);

                // envia os dados para o emprestimo processar
                if (this.objEmprestimo.AtualizarEmprestimoBD(devolucaoFormatted, id)) {
                    JOptionPane.showMessageDialog(rootPane, "Emprestimo Alterado com Sucesso!");
                    // limpa os campos
                    this.data_devolucao.setText("");
                    System.out.println(this.objEmprestimo.getListaEmprestimos().toString());
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Preencha corretamente a data de devolução!");
            }
        } catch (Mensagens1 erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());

        } catch (ParseException ex) {
            Logger.getLogger(GerenciaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_b_alterarActionPerformed

    private void jTableEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmprestimosMouseClicked

        if (this.jTableEmprestimos.getSelectedRow() != -1) {

            String data_devolucao = this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 4).toString();

            this.data_devolucao.setText(data_devolucao);
        }
    }//GEN-LAST:event_jTableEmprestimosMouseClicked

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed
        try {
            // validando dados da interface gr�fica.
            int id = 0;
            if (this.jTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagens1("Primeiro Selecione um emprestimo para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableEmprestimos.getValueAt(this.jTableEmprestimos.getSelectedRow(), 0).toString());
            }

            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este emprestimo ?");

            if (resposta_usuario == 0) {// clicou em SIM

                // envia os dados para o Emprestimo processar
                if (this.objEmprestimo.ExcluirEmprestimoBD(id)) {

                    // limpa os campos
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta Apagada com Sucesso!");

                }

            }

            System.out.println(this.objEmprestimo.getListaEmprestimos().toString());

        } catch (Mensagens1 erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_b_apagarActionPerformed

    private void data_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_devolucaoActionPerformed

    }//GEN-LAST:event_data_devolucaoActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTableEmprestimos.getModel();
        modelo.setNumRows(0);

        ArrayList<Emprestimo> minhalista = new ArrayList<>();
        minhalista = objEmprestimo.getListaEmprestimos();

        for (Emprestimo a : minhalista) {

            Ferramenta ferramenta = getFerramentaPorId(a.getFerramenta_id());
            Amigo amigo = getAmigoPorId(a.getAmigo_id());

            modelo.addRow(new Object[]{
                a.getId(),
                ferramenta != null ? ferramenta.getNome() : "",
                amigo != null ? amigo.getNome() : "",
                converterData(a.getData_emprestimo()),
                converterData(a.getData_devolucao())
            });
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaEmprestimo().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField data_devolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimos;
    // End of variables declaration//GEN-END:variables

    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo clean code1.png")));
    }
}
