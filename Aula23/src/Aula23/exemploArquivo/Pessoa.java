package Aula23.exemploArquivo;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String sobrenome;
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
@Override
    public String toString(){
        return "Nome:"+nome+" Sobrenome:"+sobrenome;
}


}
