
package Model;

import java.util.ArrayList;
import java.util.List;

public class Anunciante {
    protected String senha;
    protected int matricula;
    protected String razaoSocial;
    protected String tipo;
    protected ArrayList<Anuncio> anuncios;
    
    

    public Anunciante( String razaoSocial, String tipo, String senha) {
        this.matricula = gerarId();
        this.razaoSocial = razaoSocial;
        this.tipo = tipo;
        anuncios = new ArrayList<>();
        this.senha = senha;
       
    }

    public Anunciante( String razaoSocial, String tipo, String senha, Anuncio anuncio) {
        this.matricula = gerarId();
        this.razaoSocial = razaoSocial;
        this.tipo = tipo;
        anuncios = new ArrayList<>();
        anuncios.add(anuncio);
        this.senha = senha;
        
       
       
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    private static int geraId = 1000;
  
    public static int gerarId(){
        return geraId++;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    
   
    
   
    
    
}



