
package Model;

/**
 *
 * @author edpac
 */
public class Anuncio {
    private String titAnuncio;
    private String contAnuncio;
    private int id; 

    public Anuncio(String titAnuncio, String contAnuncio) {
        this.titAnuncio = titAnuncio;
        this.contAnuncio = contAnuncio;
        this.id = gerarId();
    }

    public Anuncio() {
    }

    public String getTitAnuncio() {
        return titAnuncio;
    }

    public void setTitAnuncio(String titAnuncio) {
        this.titAnuncio = titAnuncio;
    }

    public String getContAnuncio() {
        return contAnuncio;
    }

    public void setContAnuncio(String contAnuncio) {
        this.contAnuncio = contAnuncio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    private static int geraId = 10;
    public static int gerarId(){
        return geraId++;
  
    }
}
