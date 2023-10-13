
package Model;
import DAO.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramenta {
    private String nome;
    private String marca;
    private String custo;
    private int id;
    private final FerramentaDAO dao; 
        
        
       public Ferramenta() {
        this.dao = new FerramentaDAO(); // inicializado n�o importa em qual construtor
    }    

    public Ferramenta(String nome, String marca,String custo,int id) {
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.id =id;
        this.dao = new FerramentaDAO();
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getCusto() {
        return custo;
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
     public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setCusto(String custo) {
        this.custo = custo;
    }
    
      public String ImprimeFerramenta() {
        return "\n Nome: " + this.getNome()
                + "\n Marca:" + this.getMarca()
                + "\n Custo:" + this.getCusto()
                + "\n -----------";      
     }
  
      
            public ArrayList getListaFerramentas() {
        //return AlunoDAO.MinhaLista;
        return dao.getListaFerramentas();
    }
            
        public boolean CadastrarFerramentaBD(String nome, String marca, String custo) throws SQLException {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(nome,marca, custo,id);
        dao.CadastrarFerramentaBD(objeto);
        return true;

    }
        
        public boolean ExcluirFerramentaBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.ExcluirFerramentaBD(id);
        return true;
    }  
           public boolean AtualizarFerramentaBD(String nome, String marca, int id, String custo) {
        Ferramenta objeto = new Ferramenta(nome, marca,custo,id);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.AtualizarFerramentaBD(objeto);
        return true;
    }
      
       public int maiorID() throws SQLException{
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }         
}

