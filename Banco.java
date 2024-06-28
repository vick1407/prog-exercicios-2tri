package Aula21;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void listarContas() {
        System.out.println("Contas do banco " + nome + ":");
        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular() + ", Identificador: " + conta.getIdentificador());
        }
    }

    public Conta buscarContaPorIdentificador(String identificador) {
        for (Conta conta : contas) {
            if (conta.getIdentificador().equals(identificador)) {
                return conta;
            }
        }
        return null;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
