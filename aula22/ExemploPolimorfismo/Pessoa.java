package aula22.ExemploPolimorfismo;

public class Pessoa {
    private String nome;
    private String sobrenome;
    public String getNome(){
        return nome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public String getSobrenome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String obterDados(){
        return "Nome"+nome+" Sobrenome:"+sobrenome;
    }
    @Override
    public String toString(){
        return "Nome: "+nome+"Sobrenome:"+sobrenome;
    }

}
