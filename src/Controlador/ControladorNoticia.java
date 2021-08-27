package Controlador;

import DAO.Persistencia;
import static DAO.Persistencia.notDigital;
import static DAO.Persistencia.notImpressa;
import Model.Anuncio;
import Model.Comentario;
import Model.NoticiaDigital;
import Model.NoticiaImpressa;
import java.util.ArrayList;

/**
 *
 * @author edpac
 */
public class ControladorNoticia {

    ///////////// CRIA NOTICIA DO TIPO DIGITAL////////////
    public static void criarNoticiaDigital(String titulo, String conteudo, String categoria, String tipo) {
        Persistencia.notDigital.add(new NoticiaDigital(titulo, conteudo, categoria, tipo));
    }

    /////////////////CRIA NOTÍCIA DO TIPO IMPRESSA/////////////////
    public static void criarNoticiaImpressa(String titulo, String conteudo, String categoria, String tipo) {
        Persistencia.notImpressa.add(new NoticiaImpressa(titulo, conteudo, categoria, tipo));
    }

    //////////RETORNA LISTA DE NOTICIAS IMPRESSAS////////////
    public static ArrayList<NoticiaImpressa> listarNotImpreesa() {
        return Persistencia.notImpressa;
    }

    //////////RETORNA LISTA DE NOTICIAS DIGITAIS////////////
    public static ArrayList<NoticiaDigital> listarNotDigital() {
        return Persistencia.notDigital;
    }

    /////////////RETORNA AS NOTICIAS DIGITAIS REVISADAS///////////////////////
    public static ArrayList<NoticiaDigital> listarNotDigitalRevisadas() {
        ArrayList<NoticiaDigital> listRevisada = new ArrayList<>();
        for (NoticiaDigital not : notDigital) {
            if (not.isRevisada()) {
                listRevisada.add(not);
            }
        }
        return listRevisada;

    }

    /////////////RETORNA AS NOTICIAS DIGITAIS NÃO REVISADAS///////////////////////
    public static ArrayList<NoticiaDigital> listarNotDigitalSemRevisao() {
        ArrayList<NoticiaDigital> listNrevisada = new ArrayList<>();
        for (NoticiaDigital not : notDigital) {
            if (not.isRevisada() == false) {
                listNrevisada.add(not);
            }
        }
        return listNrevisada;

    }

    /////////////RETORNA AS NOTICIAS IMPRESSAS REVISADAS///////////////////////
    public static ArrayList<NoticiaImpressa> listarNotImpressaRevisada() {
        ArrayList<NoticiaImpressa> listRevisada = new ArrayList<>();
        for (NoticiaImpressa not : notImpressa) {
            if (not.isRevisada()) {
                listRevisada.add(not);
            }
        }
        return listRevisada;

    }

    /////////////RETORNA AS NOTICIAS IMPRESSAS SEM REVISADAS///////////////////////
    public static ArrayList<NoticiaImpressa> listarNotImpressaSemRevisao() {
        ArrayList<NoticiaImpressa> listNrevisada = new ArrayList<>();
        for (NoticiaImpressa not : notImpressa) {
            if (not.isRevisada() == false) {
                listNrevisada.add(not);
            }
        }
        return listNrevisada;
    }

    //////////REVISOR FAZ AS CORREÇÕES ORTOGRÁFICAS NA NOTÍCIA///////////////
    public static void revisarNoticia(int id, String titulo, String corpo) {
        for (int i = 0; i < Persistencia.notDigital.size(); i++) {
            if (Persistencia.notDigital.get(i).getId() == id) {
                Persistencia.notDigital.get(i).setTitulo(titulo);
                Persistencia.notDigital.get(i).setConteudo(corpo);
                Persistencia.notDigital.get(i).setRevisada(true);
            } else {
                for (int j = 0; j < Persistencia.notImpressa.size(); j++) {
                    Persistencia.notImpressa.get(j).setTitulo(titulo);
                    Persistencia.notImpressa.get(j).setConteudo(corpo);
                    Persistencia.notImpressa.get(j).setRevisada(true);
                }
            }
        }
    }

    //////////////////ADICIONA COMENTÁRIO NA NOTÍCIA//////////////////////////
    public static void comentarNoticia(int id, String titulo, String conteudo) {

        for (NoticiaDigital not : notDigital) {
            if (not.getId() == id) {
                not.getComentarios().add(new Comentario(titulo, conteudo));
            }
        }

    }

    public static void editarNoticiaDigital(int id, String link) {
        for (NoticiaDigital not : notDigital) {
            if (not.getId() == id) {
                not.setLink(link);
                not.setEditada(true);
            }
        }
    }

    public static void editarNoticiaImpressa(int id, int ano, int edicao, int numPaginas) {
        for (NoticiaImpressa not : notImpressa) {
            if (not.getId() == id) {
                not.setAno(ano);
                not.setEdicao(edicao);
                not.setNumPaginas(numPaginas);
                not.setEditada(true);
            }

        }
    }

    /////////////VINCULA ANÚNCIO NA NOTICIA///////////////////
    public static void vincularAnuncio(int id, int idNot) {
        Anuncio anuncio = new Anuncio();
        for (int i = 0; i < Persistencia.anuPublico.size(); i++) {
            for (int j = 0; j < Persistencia.anuPublico.get(i).getAnuncios().size(); j++) {
                if (Persistencia.anuPublico.get(i).getAnuncios().get(j).getId() == id) {
                    anuncio = Persistencia.anuPublico.get(i).getAnuncios().get(j);
                }
            }
        }

        for (int k = 0; k < Persistencia.anunPrivado.size(); k++) {
            for (int l = 0; l < Persistencia.anunPrivado.get(k).getAnuncios().size(); l++) {
                if (Persistencia.anunPrivado.get(k).getAnuncios().get(l).getId() == id) {
                    anuncio = Persistencia.anunPrivado.get(k).getAnuncios().get(l);
                }
            }

        }

        for (int i = 0; i < Persistencia.notDigital.size(); i++) {
            if (Persistencia.notDigital.get(i).getId() == idNot) {
                Persistencia.notDigital.get(i).getAnuncios().add(anuncio);
            }
        }

        for (int i = 0; i < Persistencia.notImpressa.size(); i++) {
            if (Persistencia.notImpressa.get(i).getId() == idNot) {
                Persistencia.notImpressa.get(i).getAnuncios().add(anuncio);
            }
        }

    }
    
    public static void publicarNoticia(int peso, int id){
        for (int i = 0; i<Persistencia.notDigital.size(); i++){
            if (Persistencia.notDigital.get(i).getId() ==id){
                Persistencia.notDigital.get(i).setAprovada(true);
                 Persistencia.notDigital.get(i).setValoracao(peso);
            }
        } 
        for (int i = 0; i<Persistencia.notImpressa.size(); i++){
            if (Persistencia.notImpressa.get(i).getId() ==id){
                Persistencia.notImpressa.get(i).setAprovada(true);
                 Persistencia.notImpressa.get(i).setValoracao(peso);
            }
        }
        
        
        
        
    }
    
    /////////////////EXCLUI UMA NOTÍCIA/////////////////////////
    public static void excluirNoticia(int idNot) {
        for (int i = 0; i < Persistencia.notDigital.size(); i++) {
            if (Persistencia.notDigital.get(i).getId() == idNot) {
                Persistencia.notDigital.remove(i);
            }
        }
        
        for (int i = 0; i  <Persistencia.notImpressa.size(); i++){
            if (Persistencia.notImpressa.get(i).getId() == idNot){
                Persistencia.notImpressa.remove(i);
            }


    }

}

}
