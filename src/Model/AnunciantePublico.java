
package Model;

/**
 *
 * @author edpac
 */
public class AnunciantePublico extends Anunciante {
    private String esfera;
    
    public AnunciantePublico(String razaoSocial, String tipo, String senha, String esfera ){
        super( razaoSocial, tipo, senha);
        this.esfera = esfera;
    }
    
    public AnunciantePublico ( String razaoSocial, String tipo, String senha, String esfera, Anuncio anuncio ){
        super(razaoSocial, tipo, senha, anuncio);
        this.esfera = esfera;
    }

    public String getEsfera() {
        return esfera;
    }

    public void setEsfera(String esfera) {
        this.esfera = esfera;
    }

   
    

 }
