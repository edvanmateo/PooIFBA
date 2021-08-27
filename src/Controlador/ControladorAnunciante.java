package Controlador;

import DAO.Persistencia;
import static DAO.Persistencia.anuPublico;
import static DAO.Persistencia.anunPrivado;
import Model.Anunciante;
import Model.AnunciantePublico;
import Model.Anuncio;
import java.util.ArrayList;

public class ControladorAnunciante {

    // CADASTRA UM ANUNCIANTE PRIVADO SEM ANUNCIO
    public static Anunciante criarAnunciantePrivado1(String razaoSocial, String tipo, String senha) {
        Anunciante a = new Anunciante(razaoSocial, tipo, senha);
        Persistencia.anunPrivado.add(a);
        return a;// esse retorna é apenas para mostrar na view a matrícula gerada pelo sistema

    }

    // CADASTRA ANUNCIANTE PRIVADO  COM ANUNCIO
    public static Anunciante criarAnunciantePrivado2(String razaoSocial, String tipo, String senha, String titulo, String conteudo) {
        Anunciante a = new Anunciante(razaoSocial, tipo, senha, new Anuncio(titulo, conteudo));
        Persistencia.anunPrivado.add(a);
        return a; // esse retorna é apenas para mostrar na view a matrícula gerada pelo sistema

    }

    // CADASTRA ANUNCIANTE PÚBLICO SEM ANÚNCIO
    public static AnunciantePublico criarAnunciantePublico1(String razaoSocial, String tipo, String senha, String esfera) {
        AnunciantePublico a = new AnunciantePublico(razaoSocial, tipo, senha, esfera);
        Persistencia.anuPublico.add(a);
        return a;// esse retorna é apenas para mostrar na view a matrícula gerada pelo sistema

    }

    // CADASTRA ANUNCIANTE PÚBLICO JÁ COM ANÚNCIO
    public static AnunciantePublico criarAnunciantePublico2(String razaoSocial, String tipo, String senha, String esfera, String titAnuncio, String contAnuncio) {
        AnunciantePublico a = new AnunciantePublico(razaoSocial, tipo, senha, esfera, new Anuncio(titAnuncio, contAnuncio));
        Persistencia.anuPublico.add(a);
        return a;// esse retorna é apenas para mostrar na view a matrícula gerada pelo sistema
    }

    // RETORNA A LISTA DE ANUNCIANTES PRIVADOS 
    public static ArrayList<Anunciante> listarAnunciantePrivado() {

        return Persistencia.anunPrivado;
    }

    //RETORNA A LISTA DE ANUNCIANTES PUBLICOS
    public static ArrayList<AnunciantePublico> listarAnunciantePublico() {
        return Persistencia.anuPublico;
    }

    //////LISTA OS ANÚNCIOS PARA UN ANUNCIANTE ESPECÍFICO///////////////
    public static ArrayList<Anuncio> listarMeusAnuncios(int matricula) {
        ArrayList<Anuncio> anuncios = new ArrayList();
        for (int i = 0; i < anuPublico.size(); i++) {
            if (anuPublico.get(i).getMatricula() == matricula) {
                for (int j = 0; j < anuPublico.get(i).getAnuncios().size(); j++) {
                    anuncios.add(anuPublico.get(i).getAnuncios().get(j));
                }
            }
        }

        for (int i = 0; i < anunPrivado.size(); i++) {
            if (anunPrivado.get(i).getMatricula() == matricula) {
                for (int j = 0; j < anunPrivado.get(i).getAnuncios().size(); j++) {
                    anuncios.add(anunPrivado.get(i).getAnuncios().get(j));
                }
            }
        }
        return anuncios;

    }

    // CRIA ANÚNCIOS  PARA ANUNCIANTES JÁ CADASTRADOS
    public static boolean criarAnuncio(int id, String titulo, String conteudo) {
        try {
            for (int i = 0; i < Persistencia.anunPrivado.size(); i++) {
                if (Persistencia.anunPrivado.get(i).getMatricula() == id) {
                    Persistencia.anunPrivado.get(i).getAnuncios().add(new Anuncio(titulo, conteudo));
                }
            }

            for (int j = 0; j < Persistencia.anuPublico.size(); j++) {
                if (Persistencia.anuPublico.get(j).getMatricula() == id) {
                    Persistencia.anuPublico.get(j).getAnuncios().add(new Anuncio(titulo, conteudo));

                }
            }
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    ///////MÉTODO PARA O ANUNCIANTE LOGAR//////////
    public static boolean logar(int matricula, String senha) {
        for (int i = 0; i < Persistencia.anunPrivado.size(); i++) {
            if (Persistencia.anunPrivado.get(i).getMatricula() == matricula && Persistencia.anunPrivado.get(i).getSenha().equals(senha)) {
                return true;
            }
        }

        for (int i = 0; i < Persistencia.anuPublico.size(); i++) {
            if (Persistencia.anuPublico.get(i).getMatricula() == matricula && Persistencia.anuPublico.get(i).getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }
}
