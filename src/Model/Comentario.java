
package Model;

/**
 *
 * @author edpac
 */
public class Comentario {
    private int id;
    private String titulo;
    private String conteudo;
    private static int contId = 1;
   
    
    public Comentario(){
        
    }
    
    public Comentario(String titulo, String conteudo){
        this.id = gerarId();
        this.titulo = titulo;
        this.conteudo = conteudo;
        
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

    public  int getId() {
        return id;
    }

   
    
    public static int gerarId(){
        return contId++;
        
    }
        
    }
    

