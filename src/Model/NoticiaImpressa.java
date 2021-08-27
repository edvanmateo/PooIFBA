
package Model;

/**
 *
 * @author edpac
 */
public class NoticiaImpressa extends Noticia  {
    
    private int edicao; 
    private int ano;
    private int numPaginas;
    
    public NoticiaImpressa(){
        
    }
    
     public NoticiaImpressa(String titulo, String conteudo,String categoria, String tipo){
        super(titulo, conteudo, categoria, tipo );
        this.ano = 0;
        this.edicao = 0;
        this.numPaginas= 0;
        
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
   
}
