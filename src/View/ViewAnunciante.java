package View;

import Controlador.ControladorAnunciante;
import Model.Anunciante;
import Model.AnunciantePublico;
import Model.Anuncio;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author edpac
 */
public class ViewAnunciante {

    //////////ANUNCIANTE FAZ SEU CADASTRO NO PORTAL////////////
    public static void criarCadastroAnunciante() throws IOException {

        System.out.println("Informe a razão social");
        String razaoSocial = Console.readString();
        System.out.println("Informe o tipo (Público ou Privado");
        String tipo = Console.readString();
        System.out.println("Crie uma senha para sua conta");
        String senha = Console.readString();

        String esfera = "";
        if (tipo.equalsIgnoreCase("publico") == true) {   // Nesse ponto o Anunciante é público ou não?

            System.out.println("Informe a esfera (Municipal, Estadul ou Federal?");
            esfera = Console.readString();
        }

        System.out.println("Deseja cadastrar um anúncio agora? Digite 'S' ou 'N'");
        char opcao = Console.readChar();

        if (opcao == 's') {
            System.out.println("Informe o titulo do anuncio");
            String titAnuncio = Console.readString();
            System.out.println("Informe o conteudo do anuncio");
            String contAnuncio = Console.readString();

            if (tipo.equalsIgnoreCase("publico")) {

                AnunciantePublico a = ControladorAnunciante.criarAnunciantePublico2(razaoSocial, tipo, senha, esfera, titAnuncio, contAnuncio);

                System.out.println("\t\t\t*****CADASTRO REALIZADO COM SUCESSO******\nAnote seus dados: \nMATRÍCULA: " + a.getMatricula()
                        + "\nSenha: " + a.getSenha()
                );

            } else {
                Anunciante a = ControladorAnunciante.criarAnunciantePrivado2(razaoSocial, tipo, senha, titAnuncio, contAnuncio);
                System.out.println("\t\t\t*****CADASTRO REALIZADO COM SUCESSO******\nAnote seus dados: \nMATRÍCULA: " + a.getMatricula()
                        + "\nSenha: " + a.getSenha()
                );
            }

        } else if (tipo.equalsIgnoreCase("publico")) {
            AnunciantePublico a = ControladorAnunciante.criarAnunciantePublico1(razaoSocial, tipo, senha, esfera);
            System.out.println("\t\t\t*****CADASTRO REALIZADO COM SUCESSO******\nAnote seus dados: \nMATRÍCULA: " + a.getMatricula()
                    + "\nSenha: " + a.getSenha()
            );

        } else {
            ControladorAnunciante.criarAnunciantePrivado1(razaoSocial, tipo, senha);
            Anunciante a = ControladorAnunciante.criarAnunciantePrivado1(razaoSocial, tipo, senha);
            System.out.println("\t\t\t*****CADASTRO REALIZADO COM SUCESSO******\nAnote seus dados: \nMATRÍCULA: " + a.getMatricula()
                    + "\nSenha: " + a.getSenha()
            );
        }
    }

//Cria um anuncio para um anunciante cadastrado
    public static void criarAnuncio() throws IOException {

        System.out.println("Informe sua matrícula");
        int id = Console.readInt();
        System.out.println("Informe o titulo do Anuncio");
        String titulo = Console.readString();
        System.out.println("Informe o conteudo do anuncio");
        String conteudo = Console.readString();
        ControladorAnunciante.criarAnuncio(id, titulo, conteudo);
    }

    public static void listarMeusAnuncios() throws IOException {

        System.out.println("Informe sua matrícula");
        int matricula = Console.readInt();
        ArrayList<Anuncio> anuncios = ControladorAnunciante.listarMeusAnuncios(matricula);
        if (anuncios.isEmpty()) {
            System.out.println("Vc não Possui annúncio cadastrado");
        } else {

            for (Anuncio anu : anuncios) {
                System.out.println("\nId do anúncio: " + anu.getId() + "\n\tTítulo: " + anu.getTitAnuncio()
                        + "\n\tConteúdo: " + anu.getContAnuncio());
            }
        }
    }
    
    public static boolean logar() throws IOException {
        System.out.println("Informe sua matrícula");
        int matricula = Console.readInt();
        System.out.println("Informe sua senha");
        String senha = Console.readString();
        if (ControladorAnunciante.logar(matricula, senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Matrícula e/ou senha incorreto. Tente outra vez\n");
            return false;
        }

    }

    public static void exibirMenuAnunciante() {
        System.out.println("\n1 - CADASTRAR ANÚNCIO \t2 - LISTAR MEUS ANÚNCIOS \t3 - PARA VOLTAR AO MENU INICIAL");
               
    }
    
    
}
