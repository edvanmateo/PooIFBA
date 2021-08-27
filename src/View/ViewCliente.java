package View;

import Controlador.ControladorCliente;
import Controlador.ControladorNoticia;
import DAO.Persistencia;
import Model.Cliente;
import Model.NoticiaDigital;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author edpac
 */
public class ViewCliente {
    
    /// CLIENTE CRIA UMA CONTA NO PORTAL //
    public static void criarConta() throws IOException{
        System.out.println("Informe seu nome");
        String nome = Console.readString();
        System.out.println("Informe seu e-mail");
        String email = Console.readString();
        System.out.println("Informe sua senha");
        String senha = Console.readString();
        Cliente c = ControladorCliente.criarConta(nome, email, senha);
        System.out.println("\nConta criada com sucesso! ATENÇÃO: Anote seus dados de Login\nNome: " + c.getNome() + "\nMatricula: " + c.getMatricula()
                + "\nSenha: " + c.getSenha()
        );
    }
    
    // CLIENTE LOGA NO SISTEMA //
    public static boolean logar() throws IOException{
        System.out.println("Informe sua matrícula");
        int matricula = Console.readInt();
        System.out.println("Informe sua senha");
        String senha = Console.readString();
        if (ControladorCliente.logar(matricula, senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Matrícula e/ou senha incorreto. Tente outra vez\n");
            return false;
        }
        
    }

     ///////////LISTA NOTICIA DO TIPO DIGITAL /////////////////
    public static void listarNoticiaDigital() {
        ArrayList<NoticiaDigital> notDigital = ControladorNoticia.listarNotDigital();

        if (notDigital.isEmpty() == false) {
            System.out.println("**********NOTÍCIAS DIGITAIS**********");
            for (NoticiaDigital not : notDigital) {

                System.out.println("\nId da noticia: " + not.getId() + "\n"
                        + "Titulo da noticia: " + not.getTitulo() + "\n"
                        + "Conteúdo da Notícia: " + not.getConteudo() + "\n"
                        + "Categoria da Notícia: " + not.getCategoria() + "\n"
                        + "Tipo da Notíca: " + not.getTipo() + "\n"
                        + "Valoração da Notícia: " + not.getValoracao() + "\n"
                        + "Data da Notícia: " + not.getData() + "\n"
                        + "Conteudo dinâmico: " + not.getLink());
                for (int i = 0; i < not.getComentarios().size(); i++) {
                    System.out.println("Comentário " + not.getComentarios().get(i).getId() + "\n"
                            + "\tTítulo: " + not.getComentarios().get(i).getTitulo() + "\n"
                            + "\tConteudo: " + not.getComentarios().get(i).getConteudo()+"\n");
                }


                for (int i = 0; i < not.getAnuncios().size(); i++) {
                    System.out.println("\nAnuncio: " + not.getAnuncios().get(i).getId() + "\n"
                            + "\t Título: " + not.getAnuncios().get(i).getTitAnuncio() + "\n"
                            + "\t Conteúdo: " + not.getAnuncios().get(i).getContAnuncio()+ "\n"
                    );
                }

            }// chave for

        } else {
            System.out.println("\nNão existem notícias do tipo digital\n");
        }
    }

    //////////VINCULA COMENTÁRIOS A NOTÍCIA DIGITAL////////////
    public static void comentarNoticia() throws IOException {
        

        if (ControladorNoticia.listarNotDigital().isEmpty()) {
            System.out.println("Não existem Notícias Digitais");
        } else {
            ViewCliente.listarNoticiaDigital();
            System.out.println("\nEscolha o Id da Notícia que deseja comentar");
            int id = Console.readInt();           
            System.out.println("Digite o título para o comentário");
            String titulo = Console.readString();
            System.out.println("Digite seu comentário");
            String conteudo = Console.readString();
            ControladorNoticia.comentarNoticia(id, titulo, conteudo);
            
        }

    }

    public static void exibirMenu() {
        System.out.println("\t\t\t\tOLÁ CLIENTE!\n");
        System.out.println("1 - Visulaizar Notícia \t\t 2 -  Comentar Notícia \t\t 3- Voltar ao Menu Inicial");
    }
}
