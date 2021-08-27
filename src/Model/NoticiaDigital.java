/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edpac
 */
public class NoticiaDigital extends Noticia {
    private  String link;
    private List<Comentario> comentarios;
    
    
    public NoticiaDigital(){
        
    }
    
    public NoticiaDigital(String titulo, String conteudo,String categoria, String tipo ){
        super(titulo, conteudo, categoria, tipo);
        this.link = "";
        this.comentarios = new ArrayList<>();
    }

    public  String getLink() {
        return link;
    }

     public void setLink(String link) {
        this.link = link;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
}
