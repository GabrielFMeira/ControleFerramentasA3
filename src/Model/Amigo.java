/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import DAO.AmigoDAO;
import java.sql.SQLException;


public class Amigo {
    private String nome;
    private String telefone;
    private int id;
    private final AmigoDAO dao; 
    
      public Amigo() {
        this.dao = new AmigoDAO(); // inicializado n�o importa em qual construtor
    }
    
  

    public Amigo(String nome, String telefone, int id) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
        this.dao = new AmigoDAO();
        
 
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
    
     public int getId() {
        return id;
    }

      public void setNome(String nome) {
        this.nome = nome;
    }
        public void setId(int id) {
        this.id = id;
    }
      
          public void setTelefone(String telefone) {
        this.telefone = telefone;
    }  
    
     public String ImprimeAmigo() {
        return "\n id: " + this.getId()
                + "+\n Nome: " + this.getNome()
                + "\n Telefone:" + this.getTelefone()
                + "\n -----------";      
     }
          
            public ArrayList getListaAmigos() {
        //return AlunoDAO.MinhaLista;
        return dao.getListaAmigos();
    }
            
        public boolean CadastrarAmigoBD(String nome, String telefone) throws SQLException {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(nome,telefone,id);
        dao.CadastrarAmigoBD(objeto);
        return true;

    }
        
        public boolean ExcluirAmigoBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.ExcluirAmigoBD(id);
        return true;
    }  
           public boolean AtualizarAmigoBD(String nome, int id, String telefone) {
        Amigo objeto = new Amigo(nome, telefone, id);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.AtualizarAmigoBD(objeto);
        return true;
    }
             public Amigo CarregaAmigo(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.CarregaAmigo(id);
        return null;
    }
      
       public int maiorID() throws SQLException{
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }         
         @Override
    public String toString(){
        return this.getNome();
    }   
}
