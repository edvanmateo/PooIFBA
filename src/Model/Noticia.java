
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author edpac
 */
public class Noticia {
    protected boolean aprovada;
    protected int id;
    protected String titulo;
    protected String conteudo;
    protected String categoria;
    protected String tipo;
    protected int valoracao;
    protected Date data;
    protected boolean revisada;
    protected boolean editada;
    private static  int contId = 1 ;
    protected List<Anuncio> anuncios;
   
        
    
    public Noticia(){
        
    }
    
    
    public Noticia (String titulo, String conteudo, String categoria,String tipo  ){
        this.id = gerarId();
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.categoria = categoria;
        this.tipo = tipo;
        this.valoracao = 0;
        this.data = new Date();
        this.revisada = false;
        this.editada = false;
        this.anuncios = new ArrayList();
        this.aprovada = false;
      
      
       
    }
       
        


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValoracao() {
        return valoracao;
    }

    public void setValoracao(int valoracao) {
        this.valoracao = valoracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isRevisada() {
        return revisada;
    }

    public void setRevisada(boolean revisada) {
        this.revisada = revisada;
    }

    public boolean isEditada() {
        return editada;
    }

    public void setEditada(boolean editada) {
        this.editada = editada;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    
    
    public static int gerarId(){
        
        return contId++;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }


   
  
    
    
}

