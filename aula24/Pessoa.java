package aula24;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L; // Necessário para serialização
    private String nome;
    private String sobrenome;

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " " + sobrenome;
    }
}
