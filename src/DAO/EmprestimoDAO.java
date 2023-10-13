/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Emprestimo;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class EmprestimoDAO {

    public static ArrayList<Emprestimo> ListaEmprestimos = new ArrayList<Emprestimo>();

    public EmprestimoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM emprestimos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {

        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;  //inst�ncia da conex�o

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "db_gerenciadorv1";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "gugu1103";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    public ArrayList getListaEmprestimos() {

        ListaEmprestimos.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM emprestimos");
            while (res.next()) {

                int id = res.getInt("id");
                int ferramenta_id = res.getInt("ferramenta_id");
                int amigo_id = res.getInt("amigo_id");
                String data_emprestimo = res.getString("data_emprestimo");
                String data_devolucao = res.getString("data_devolucao");

                Emprestimo objeto = new Emprestimo(ferramenta_id, amigo_id, data_emprestimo, data_devolucao, id);

                ListaEmprestimos.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return ListaEmprestimos;
    }

   public boolean CadastrarEmprestimoBD(Emprestimo objeto) {
        if (verificarFerramentaEmprestada(objeto.getFerramenta_id())) {
        return false; // Ferramenta já emprestada, não é possível realizar o novo empréstimo
    }
    String sql = "INSERT INTO emprestimos (ferramenta_id, amigo_id, data_emprestimo, data_devolucao, id) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement stmt = this.getConexao().prepareStatement(sql);

        stmt.setInt(1, objeto.getFerramenta_id());
        stmt.setInt(2, objeto.getAmigo_id());
        stmt.setString(3, objeto.getData_emprestimo());

        if (objeto.getData_devolucao().isEmpty()) {
            stmt.setNull(4, java.sql.Types.DATE);
        } else {
            stmt.setString(4, objeto.getData_devolucao());
        }

        stmt.setInt(5, objeto.getId());

        stmt.execute();
        stmt.close();

        return true;

    } catch (SQLException erro) {
        throw new RuntimeException(erro);
    }
}

    public boolean ExcluirEmprestimoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM emprestimos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean AtualizarEmprestimoBD(Emprestimo objeto) {
    String sql = "UPDATE emprestimos SET data_devolucao = ? WHERE id = ?";

    try {
        PreparedStatement stmt = this.getConexao().prepareStatement(sql);

        if (objeto.getData_devolucao().isEmpty()) {
            stmt.setNull(1, java.sql.Types.DATE);
        } else {
            stmt.setString(1, objeto.getData_devolucao());
        }
        
        stmt.setInt(2, objeto.getId());

        stmt.executeUpdate();
        stmt.close();

        return true;

    } catch (SQLException erro) {
        throw new RuntimeException(erro);
    }
}

    public Emprestimo CarregaEmprestimo(int id) {

        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id = " + id);
            res.next();

            objeto.setFerramenta_id(res.getInt("ferramenta_id"));
            objeto.setAmigo_id(res.getInt("amigo_id"));
            objeto.setData_emprestimo(res.getString("data_emprestimo"));
            objeto.setData_devolucao(res.getString("data_devolucao"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
    public boolean verificarFerramentaEmprestada(int ferramentaId) {
    try {
        Statement stmt = this.getConexao().createStatement();
        ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS count FROM emprestimos WHERE ferramenta_id = " + ferramentaId);
        res.next();
        int count = res.getInt("count");

        stmt.close();

        return count > 0; // Retorna true se a contagem for maior que zero (ferramenta emprestada), caso contrário, retorna false

    } catch (SQLException erro) {
        throw new RuntimeException(erro);
    }
}

}
