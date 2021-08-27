
package Model;

/**
 *
 * @author edpac
 */
public class Funcionario{
    protected String nome;
    protected int matricula; 
    protected String senha;
    private static int contId  =2500;
    
    
    public Funcionario( String nome, String senha){
        this.matricula = gerarId();
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    public static int gerarId(){
        
        return contId++;
    }
    
}
    

