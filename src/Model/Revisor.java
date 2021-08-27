/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author edpac
 */
public class Revisor extends Funcionario{

    public Revisor( String nome, String senha) {
        super( nome, senha);
    }
    
   
    public double calcularRemuneracao(double salario){
        return 0;
    }
    
}
