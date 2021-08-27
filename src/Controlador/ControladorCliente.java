/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Persistencia;
import Model.Cliente;

/**
 *
 * @author edpac
 */
public class ControladorCliente {
    
    /// CRIA UMA CONTA PARA CLIENTE E ADD NA LISTA // 
    public static Cliente criarConta(String nome, String eMail, String senha){
        Cliente c = new Cliente(nome, eMail, senha);
        Persistencia.clientes.add(c);
        return c;
    
}
    // MÉTODO PARA CLIENTE LOGAR // 
    public static boolean logar(int matricula, String senha){
        for (int i = 0; i < Persistencia.clientes.size(); i++){
            if (Persistencia.clientes.get(i).getMatricula() == matricula && Persistencia.clientes.get(i).getSenha().equals(senha))
                return true;
            }
        return false;
        }
    }

