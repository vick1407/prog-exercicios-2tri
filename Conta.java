package Aula21;

import java.util.Random;

public class Conta {
    private String titular;
    private String identificador;
    private static String NOME_BANCO;
    private float saldo;

    public Conta(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.geraIdentificador();
    }

    boolean sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    void depositar(float valor) {
        saldo += valor;
    }

    private void geraIdentificador() {
        Random aleatorio = new Random();
        StringBuilder identificador = new StringBuilder();

        // Gerando 4 caracteres aleatórios de A a Z
        for (int i = 0; i < 4; i++) {
            char randomChar = (char) (aleatorio.nextInt(26) + 'A');
            identificador.append(randomChar);
        }

        // Gerando número aleatório entre 1000 e 1999
        int randomNumber = aleatorio.nextInt(1000, 2000);
        identificador.append(randomNumber);

        this.identificador = identificador.toString();
    }

    String verificarSaldo() {
        return String.format("Seu saldo é de R$%.2f", saldo);
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static void setNomeBanco(String nomeBanco) {
        NOME_BANCO = nomeBanco;
    }
}
