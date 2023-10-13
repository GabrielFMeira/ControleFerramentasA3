/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import DAO.EmprestimoDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;



public class Emprestimo {
    private int id;
    private int ferramenta_id;
    private int amigo_id;
    private  String data_emprestimo;
    private  String data_devolucao;
    private final EmprestimoDAO dao;
    
    
     
     public Emprestimo() {
        this.dao = new EmprestimoDAO(); // inicializado n�o importa em qual construtor
    }
    
    

      public Emprestimo(int ferramenta_id, int amigo_id,  String data_emprestimo,  String data_devolucao, int id) {
        this.ferramenta_id = ferramenta_id;
        this.amigo_id = amigo_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.id = id;
          this.dao = new EmprestimoDAO();
    }

    public int getFerramenta_id() {
        return ferramenta_id;
    }

    public void setFerramenta_id(int ferramenta_id) {
        this.ferramenta_id = ferramenta_id;
    }

    public int getAmigo_id() {
        return amigo_id;
    }

    public void setAmigo_id(int amigo_id) {
        this.amigo_id = amigo_id;
    }

    public  String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo( String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public  String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao( String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String ImprimeEmprestimo() {
        return "\n id: " + this.getId()
                + "\n ferramenta_id:" + this.getFerramenta_id()
                + "\n amigo_id:" + this.getAmigo_id()
                + "\n data_emprestimo:" + this.getData_emprestimo()
                  + "\n data_devolucao:" + this.getData_devolucao()
                + "\n -----------";      
     }
  
      
            public ArrayList getListaEmprestimos() {
        //return AlunoDAO.MinhaLista;
        return dao.getListaEmprestimos();
    }
            
  
    public boolean CadastrarEmprestimoBD(int ferramenta_id, int amigo_id,  String data_emprestimo,  String data_devolucao) throws SQLException {
         
        int id = this.maiorID() + 1;
        
        
        Emprestimo objeto = new Emprestimo(ferramenta_id,amigo_id,data_emprestimo,data_devolucao,id);
        dao.CadastrarEmprestimoBD(objeto);
        return true;

    }
        
        public boolean ExcluirEmprestimoBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.ExcluirEmprestimoBD(id);
        return true;
    }  
          public Emprestimo CarregaEmprestimo(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.CarregaEmprestimo(id);
        return null;
    }
           public boolean AtualizarEmprestimoBD(String data_devolucao, int id) {
        Emprestimo objeto = new Emprestimo(ferramenta_id,amigo_id,data_emprestimo,data_devolucao,id);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.AtualizarEmprestimoBD(objeto);
        return true;
    }
      
       public int maiorID() throws SQLException{
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }         
}