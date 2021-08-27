package View;

import java.io.IOException;

/**
 *
 * @author edpac
 */
public class ViewPortalMain {

    public static void main(String[] args) throws IOException {
        int opcaoCase = -1;
        boolean log = false;

        while (opcaoCase != 0) {
            try {

                exibirMenuPortal();
                opcaoCase = Console.readInt();

                switch (opcaoCase) {
                    case 1 -> {
                        do {
                            try {
                                exibirMenuLogin();// CONTROLE DE LOGIN // 
                                int op = Console.readInt();
                                switch (op) {
                                    
                                    case 1 -> {
                                        ViewFuncionario.criarConta();
                                    }
                                    case 2 -> {
                                        if (ViewFuncionario.logar()) {
                                            log = true;
                                        } else {

                                        }
                                    }
                                    case 3 -> {
                                        System.exit(0);
                                    }

                                }
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                            }


                        } while (log == false);

                        do {

                            ViewFuncionario.exibirMenuFuncionario();
                            opcaoCase = Console.readInt();

                            switch (opcaoCase) {

                                case 1 -> { //  JORNALISTA ESCREVE UMA NOTICIA // 
                                    ViewFuncionario.criarNoticiaView();
                                }
                                case 2 -> { // LISTA TODAS AS NOTÍCIAS DO SISTEMA // 
                                    ViewFuncionario.listarNoticiaDigital();
                                    ViewFuncionario.listarNoticiaImpressa();
                                }
                                case 3 -> { // EDITOR EDITA A NOTICIA //
                                    ViewFuncionario.editarNoticiaView();
                                }
                                case 4 -> { // REVISOR REVISA A NOTICIA // 
                                    ViewFuncionario.revisarNoticiaView();

                                }
                                case 5 -> { // CONSULTOR DE MARKETING VINCULA ANÚNCIO A NOTICIA // 
                                    ViewFuncionario.vincularAnuncio();
                                }
                                case 6 -> { // LISTA ANUNCIANTES CADASTRADOS NO SISTEMA //
                                    ViewFuncionario.listarAnunciantePrivado();
                                    ViewFuncionario.listarAnunciantePublico();
                                }
                                case 7 -> { // EXCLUI UMA NOTICIA //
                                    ViewFuncionario.excluirNoticia();
                                }
                                case 8 -> {// PUBLICA UMA NOTICIA //
                                    ViewFuncionario.publicarNoticia();
                                }
                                case 9 -> { // LISTA FUNCIONARIOS CADASTRADOS //
                                    ViewFuncionario.listarFuncionario();
                                }
                                case 10 -> {
                                }
                            }
                        } while (opcaoCase != 10);
                    }

                    case 2 -> { // CLIENTE //

                        do { // CONTROLE DE LOGIN - SIMPLES MAS FUNCIONAL //
                            try { // CONTROLE DE EXCEÇÃO CASO DIGITE UMA STRING NO LUGAR DE UM INT // //
                                exibirMenuLogin();
                                int op = Console.readInt();

                                switch (op) {

                                    case 1 -> {
                                        ViewCliente.criarConta();
                                    }
                                    case 2 -> {
                                        if (ViewCliente.logar()) {
                                            log = true;

                                        } else {

                                        }
                                    }
                                    case 3 -> {
                                        System.exit(0);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                            }

                        } while (log == false);
                        
                        // PASSANDO NO LOGIN ENTRA NESSE MENU ABAIXO //
                        
                        do { 
                            ViewCliente.exibirMenu();
                            opcaoCase = Console.readInt();

                            switch (opcaoCase) {
                                case 1 -> { // CLIENTE LER AS NOTICIAS //
                                    ViewCliente.listarNoticiaDigital(); 
                                }
                                case 2 -> { // CLIENTE COMENTA NOTÍCIA // 
                                    ViewCliente.comentarNoticia();
                                }
                                case 3 -> { // VOLTA AO MENU INICIAL //
                                    opcaoCase = 10; 
                                }
                            }

                        } while (opcaoCase != 10);

                    }
                        
                    case 3 -> { // ANUNCIANTE // 

                        do { // CONTROLE DE LOGIN //
                            try {
                                exibirMenuLogin();
                                int op = Console.readInt();

                                switch (op) {

                                    case 1 -> { // ANUNCIANTE CRIA UMA CONTA NO PORTAL //
                                        ViewAnunciante.criarCadastroAnunciante();
                                    }

                                    case 2 -> { // ANUNCIANTE LOGA NO PORTAL //
                                        if (ViewAnunciante.logar()) {
                                            log = true;

                                        } else {

                                        }
                                    }

                                    case 3 -> { // ENCERRA A APLICAÇÃO // 
                                        System.exit(0);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                            }

                        } while (log == false);
                        
                       // PASSANDO NO LOGIN ENTRA NESSE MENU ABAIXO // 
                       
                       do {
                            ViewAnunciante.exibirMenuAnunciante();
                            opcaoCase = Console.readInt();

                            switch (opcaoCase) {
                                case 1 -> { // ANUNCIANTE CRIA ANÚNCIOS NA SUA CONTA //
                                    ViewAnunciante.criarAnuncio();
                                }

                                case 2 -> { // ANUNCIANTE LISTA DEUS ANÚNCIOS PELA MATRICULA //
                                    ViewAnunciante.listarMeusAnuncios();
                                }
                                case 3 -> { // VOLTA AO MENU INICIAL //
                                    opcaoCase = 10;
                                }

                            }
                        } while (opcaoCase != 10);
                    }

                    case 4 -> {
                        opcaoCase = 0;

                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de entrada inválido. Digite um número inteiro");
            }

        }
    } // CHAVE DA MAIN

    public static void exibirMenuPortal() {
        System.out.println("\n\t\t\t\tBEM VINDO\n\n\t\t\tESCOLHA A OPÇÃO DESEJADA\n");
        System.out.println("1 - PARA FUNCIONÁRIOS\t\t\t 2 - PARA CLIENTES\n"
                + "3 - PARA ANUNCIANTES \t\t\t 4 - ENCERRAR APLICAÇÃO");

    }

    public static void exibirMenuLogin() {
        System.out.println("\t\t\t***PORTAL DE NOTÍCIAS***\n\n 1 - Criar Conta\t\t 2 - Logar\t\t3 - Sair");
    }

}



















                                

