package View;

import Controlador.ControladorAnunciante;
import Controlador.ControladorFuncionario;
import Controlador.ControladorNoticia;
import DAO.Persistencia;
import Model.Anunciante;
import Model.AnunciantePublico;
import Model.Funcionario;
import Model.NoticiaDigital;
import Model.NoticiaImpressa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edpac
 */
public class ViewFuncionario {

    public static void criarNoticiaView() throws IOException {
        
        System.out.println("Informe titulo");
        String titulo = Console.readString();
        System.out.println("Informe conteudo");
        String conteudo = Console.readString();
        System.out.println("Informe a categoria");
        String categoria = Console.readString();
        System.out.println("Informe o tipo? Digital ou Ipressa");
        String tipo = Console.readString();

        if (tipo.equalsIgnoreCase("digital")) {
            ControladorNoticia.criarNoticiaDigital(titulo, conteudo, categoria, tipo);
        } else {
            Persistencia.notImpressa.add(new NoticiaImpressa(titulo, conteudo, categoria, tipo));
        }
    }

    public static void editarNoticiaView() throws IOException {

        System.out.println("Qual tipo de Notícia deseja editar?\n 1- Digital \t 2- Impressa");
        int tipo = Console.readInt();
        if (tipo == 1) {
            ControladorNoticia.listarNotDigital();
            System.out.println("Escolhe o id da notícia que deseja editar");
            int id = Console.readInt();
            System.out.println("Informe o link dos conteúdos digitais");
            String link = Console.readString();
            ControladorNoticia.editarNoticiaDigital(id, link);
        } else {
            System.out.println("Escolhe o id da notícia que deseja editar");
            int id = Console.readInt();
            System.out.println("Informe o ano da publicação");
            int ano = Console.readInt();
            System.out.println("Informe a edição");
            int edicao = Console.readInt();
            System.out.println("Informe o número de páginas");
            int numPaginas = Console.readInt();
            ControladorNoticia.editarNoticiaImpressa(id, ano, edicao, numPaginas);
        }
    }

    //////////////REVISA AS NOTÍCIAS/////////////////////////
    public static void revisarNoticiaView() throws IOException {

        ControladorNoticia.listarNotDigital();
        ControladorNoticia.listarNotImpreesa();

        System.out.println("Escolha o id da Noticia que deseja revisar");
        int id = Console.readInt();
        System.out.println("Faça as devidas correções no Título");
        String titulo = Console.readString();
        System.out.println("Faça as devidas correções no corpo da notícia");
        String corpo = Console.readString();
        ControladorNoticia.revisarNoticia(id, titulo, corpo);

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
                            + "\tConteudo: " + not.getComentarios().get(i).getConteudo());
                }

                if (not.isAprovada()) {
                    System.out.println("Notícia Aprovada e Publicada");
                } else {
                    System.out.println("Noticia aguardando aprovação");

                }
                if (not.isRevisada()) {
                    System.out.println("Notícia Revisada");
                } else {
                    System.out.println("Sem revisão");
                }
                if (not.isEditada()) {
                    System.out.println("Noticia editada");
                } else {
                    System.out.println("Sem edição");
                }

                for (int i = 0; i < not.getAnuncios().size(); i++) {
                    System.out.println("\nAnuncio: " + not.getAnuncios().get(i).getId() + "\n"
                            + "\t Título: " + not.getAnuncios().get(i).getTitAnuncio() + "\n"
                            + "\t Conteúdo: " + not.getAnuncios().get(i).getContAnuncio() + "\n"
                    );
                }

            }// chave for

        } else {
            System.out.println("\nNão existem notícias do tipo digital\n");
        }
    }

    ///////////LISTA NOTICIA DO TIPO IMPRESSA /////////////////
    public static void listarNoticiaImpressa() {
        ArrayList<NoticiaImpressa> notImpressa = ControladorNoticia.listarNotImpreesa();
        if (notImpressa.isEmpty() == false) {
            System.out.println("**********NOTÍCIAS IMPRESSAS**********");
            for (NoticiaImpressa not : notImpressa) {

                System.out.println("\nId da noticia: " + not.getId() + "\n"
                        + "Titulo da noticia: " + not.getTitulo() + "\n"
                        + "Conteúdo da Notícia: " + not.getConteudo() + "\n"
                        + "Categoria da Notícia: " + not.getCategoria() + "\n"
                        + "Tipo da Notíca: " + not.getTipo() + "\n"
                        + "Valoração da Notícia: " + not.getValoracao() + "\n"
                        + "Data da Notícia: " + not.getData() + "\n"
                        + "Ano: " + not.getAno() + "\n"
                        + "Edição: " + not.getEdicao() + "\n"
                        + "Numero de Páginas: " + not.getNumPaginas());

                if (not.isAprovada()) {
                    System.out.println("Notícia Aprovada e Publicada");
                } else {
                    System.out.println("Noticia aguardando aprovação");

                }
                if (not.isRevisada()) {
                    System.out.println("Notícia Revisada");
                } else {
                    System.out.println("Sem revisão");
                }
                if (not.isEditada()) {
                    System.out.println("Noticia editada");
                } else {
                    System.out.println("Sem edição");
                }

                for (int i = 0; i < not.getAnuncios().size(); i++) {
                    System.out.println("\nAnuncio: " + not.getAnuncios().get(i).getId() + "\n"
                            + "\t Título: " + not.getAnuncios().get(i).getTitAnuncio() + "\n"
                            + "\t Conteúdo: " + not.getAnuncios().get(i).getContAnuncio() + "\n"
                    );
                }
            }// chave for

        } else {
            System.out.println("\nNão existem notícias do tipo impressa\n");
        }
    }

   

    /////////LISTA OS ANUNCIANTES PRIVADOS CADASTRADOS//////////////
    public static void listarAnunciantePrivado() {
        ArrayList<Anunciante> listAnunciantes = ControladorAnunciante.listarAnunciantePrivado();
        if (listAnunciantes.isEmpty() == true) {
            System.out.println("NÃO EXISTEM ANUNCIANTES PRIVADOS CADASTRADOS");
        } else {
            System.out.println("******ANUNCIANTES PRIVADOS******");
        }

        for (int i = 0; i < listAnunciantes.size(); i++) {

            System.out.println("\nMatricula do anunciante: " + listAnunciantes.get(i).getMatricula() + "\n"
                    + "Razão Social:" + listAnunciantes.get(i).getRazaoSocial() + "\n"
                    + "Tipo do anunciante:" + listAnunciantes.get(i).getTipo() + "\n");
            if (listAnunciantes.get(i).getAnuncios().isEmpty() == true) {
                System.out.println("Não esxistem anúncios cadastrado para esse anunciante");
            }

            for (int j = 0; j < listAnunciantes.get(i).getAnuncios().size(); j++) {

                System.out.println("ID doAnuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getId() + "\nTitulo do Anuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getTitAnuncio() + "\n"
                        + "Conteudo do Anuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getContAnuncio() + "\n\n");

            }
        }
    }

//////LISTAR ANUNCIANTES PÚBLCOS///////
    public static void listarAnunciantePublico() {
        ArrayList<AnunciantePublico> listAnunciantes = ControladorAnunciante.listarAnunciantePublico();
        if (listAnunciantes.isEmpty() == true) {
            System.out.println("NÃO EXISTEM ANUNCIANTES PÚBLICOS CADASTRADOS");
        } else {
            System.out.println("ANUNCIANTES PÚBLICOS");
        }

        for (int i = 0; i < listAnunciantes.size(); i++) {

            System.out.println("\nMatricula do anunciante: " + listAnunciantes.get(i).getMatricula() + "\n"
                    + "Razão Social:" + listAnunciantes.get(i).getRazaoSocial() + "\n"
                    + "Tipo do anunciante:" + listAnunciantes.get(i).getTipo() + "\n"
                    + "Esfera: " + listAnunciantes.get(i).getEsfera() + "\n\n");

            if (listAnunciantes.get(i).getAnuncios().isEmpty() == true) {
                System.out.println("Não esxistem anúncios cadastrado para esse anunciante");
            }

            for (int j = 0; j < listAnunciantes.get(i).getAnuncios().size(); j++) {

                System.out.println("ID do Anuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getId() + "\nTitulo do Anuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getTitAnuncio() + "\n"
                        + "Conteudo do Anuncio: " + listAnunciantes.get(i).getAnuncios().get(j).getContAnuncio() + "\n\n");

            }
        }
    }

    //////////VINCULAR ANÚNCIOS A NOTICIA////////////////
    public static void vincularAnuncio() throws IOException {
        if (ControladorAnunciante.listarAnunciantePrivado().isEmpty() && ControladorAnunciante.listarAnunciantePublico().isEmpty()) {
            System.out.println("Não esxistem Anunciantes Cadastrados");
        } else {

            listarNoticiaDigital();
            listarNoticiaImpressa();
            System.out.println("\nSelecione o id da Notícia que deseja vincular o anuncios");
            int idNot = Console.readInt();
            listarAnunciantePublico();
            listarAnunciantePrivado();
            System.out.println("Escolha o id do anuncio desejado");
            int id = Console.readInt();
            ControladorNoticia.vincularAnuncio(id, idNot);
        }
    }

    public static void excluirNoticia() throws IOException {
        listarNoticiaImpressa();
        listarNoticiaDigital();
        System.out.println("\nEscolha o id da notícia que deseja excluit");
        int idNot = Console.readInt();
        ControladorNoticia.excluirNoticia(idNot);
    }

    public static void publicarNoticia() throws IOException {
        ViewFuncionario.listarNoticiaDigital();
        ViewFuncionario.listarNoticiaImpressa();
        System.out.println("Escolha o id da notícia que deseja publclar");
        int id = Console.readInt();
        System.out.println("Por gentileza, qual o peso da noticia");
        int peso = Console.readInt();
        ControladorNoticia.publicarNoticia(peso, id);

    }

    public static void criarConta() throws IOException {
        System.out.println("Digite seu nome");
        String nome = Console.readString();
        System.out.println("Crie uma senha - Pode conter letras, númros e caracteres especias");
        String senha = Console.readString();
        Funcionario f = ControladorFuncionario.criarConta(nome, senha);
        System.out.println("Conta criada com sucesso! ATENÇÃO: Anote seus dados de Login:\nNome: " + f.getNome() + "\nMatricula: " + f.getMatricula()
                + "\nSenha: " + f.getSenha()
        );

    }

    public static boolean logar() throws IOException {
        System.out.println("Informe sua matrícula");
        int matricula = Console.readInt();
        System.out.println("Informe sua senha");
        String senha = Console.readString();
        if (ControladorFuncionario.logar(matricula, senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Matrícula e/ou senha incorreto. Tente outra vez\n");
            return false;
        }

    }

    public static void listarFuncionario() {
        List<Funcionario> funcionarios = ControladorFuncionario.listarFuncionario();
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("\nNome: " + funcionarios.get(i).getNome() + "\nMatrícula: " + funcionarios.get(i).getMatricula());

        }

    }
    
   

    public static void exibirMenuFuncionario() {
        System.out.println("\t\t\tOLÁ CARO COLABORADOR! ESCOLHA A OPÇÃO DESEJADA\n\n1 - Escrever Notícia \t\t 2- Listar Notícias"
                + "\t\t3 -Editar Notícia\n4 - Revisar Notícias \t\t 5 - Vincular Anúncios \t\t6 - Listar Anunciantes\n"
                + "7 - Excluir Noticia\t\t 8 - Publicar Noticia\t\t9 - Listar Funcionários\n10 - Voltar ao Menu Inicial ");
    }

    public static void exibirMenuLogin() {
        System.out.println("\t\t\t***PORTAL DE NOTÍCIAS***\n\n 1 - Criar Conta\t\t 2 - Logar\t\t3 - Sair");
    }

}
