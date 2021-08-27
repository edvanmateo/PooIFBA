/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Cliente {
    private String nome;
    private int matricula;
    private String senha;
    private String eMail;
    private static int contId = 3500;
    
    public Cliente(String nome, String eMail, String senha){
        this.nome = nome;
        this.eMail = eMail;
        this.senha = senha;
        this.matricula = gerarId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
    
    public static int gerarId(){
         return contId++;
    }
    
}
