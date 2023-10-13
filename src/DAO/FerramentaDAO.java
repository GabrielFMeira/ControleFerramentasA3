/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Ferramenta;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


        public class FerramentaDAO {
    
        public static ArrayList<Ferramenta> ListaFerramentas = new ArrayList<Ferramenta>();    


        public FerramentaDAO(){}


 public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM ferramentas");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
            
        }

        return maiorID;
    }

   public Connection getConexao() {

        Connection connection = null ;  //inst�ncia da conex�o

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
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
   
       public ArrayList getListaFerramentas() {
        
        ListaFerramentas.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas ORDER BY nome");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");            
                String marca = res.getString("marca");
                String custo = res.getString("custo");
  
                Ferramenta objeto = new Ferramenta(nome,marca,custo,id);

                ListaFerramentas.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return ListaFerramentas;
    }
 public boolean CadastrarFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO ferramentas(nome,marca,id,custo) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
             stmt.setInt(3,objeto.getId());
            stmt.setString(4, objeto.getCusto());
           
           
           
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean ExcluirFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM ferramentas WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

 // Edita um aluno espec�fico pelo seu campo ID
    public boolean AtualizarFerramentaBD(Ferramenta objeto) {

        String sql = "UPDATE ferramentas set nome = ? ,marca = ? ,custo = ?  WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setString(3, objeto.getCusto());
            stmt.setInt(4,objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    
  

   
}