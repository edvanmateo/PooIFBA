/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Anunciante;
import Model.AnunciantePublico;
import Model.Cliente;
import Model.Funcionario;
import Model.NoticiaDigital;
import Model.NoticiaImpressa;
import java.util.ArrayList;

/**
 *
 * @author edpac
 */
public class Persistencia {
    
    public static ArrayList<NoticiaDigital> notDigital = new ArrayList();
    public static ArrayList<NoticiaImpressa> notImpressa = new ArrayList();
    public static ArrayList<Anunciante> anunPrivado = new ArrayList();
    public static ArrayList<AnunciantePublico> anuPublico = new ArrayList();
    public static ArrayList<Funcionario> funcionarios = new ArrayList();
    public static ArrayList<Cliente> clientes = new ArrayList();
    
}
