/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Persistencia;
import Model.Funcionario;
import java.util.List;

/**
 *
 * @author edpac
 */
public class ControladorFuncionario {
    
    ///////CRIA UMA CONT NO PORTAL PARA UM FUNCIONÁRIO///////////
    public static Funcionario criarConta(String nome, String senha) {

        Funcionario f = new Funcionario(nome,senha);
        Persistencia.funcionarios.add(f);

        return f; // RETORNA O FUNCUIONARIO CRIADO PARA A VIEW PARA INFORMAR 
        //AO FUNCIONÁRIO A MATRÍCULA GERADA.

    }
    
    ///////MÉLTODO PARA O FUNCIONÁRIO LOGAR//////////
    public static boolean logar(int matricula, String senha) {
        for (int i = 0; i < Persistencia.funcionarios.size(); i++) {
            if (Persistencia.funcionarios.get(i).getMatricula() == matricula && Persistencia.funcionarios.get(i).getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    
    ///////LISTA OS FUNCIONÁRIOS CADATRADOS NO PORTAL/////////
    public static List<Funcionario> listarFuncionario(){
        return Persistencia.funcionarios;
    }
    
    
}
