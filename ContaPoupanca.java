package Aula21;

public class ContaPoupanca {
    private String identificador;
    private String titular;
    private float saldo;

    static String nomeBanco;

    public String obterNomeBanco(){
        return nomeBanco;
    }

    public void setarNomeBanco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }

    public ContaPoupanca(String titular, String identificador, float saldoInicial){
        this.identificador = identificador;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void setarIdentificador(String identificador){
        this.identificador = identificador;
    }


}
