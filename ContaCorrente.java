package Aula21;

public class ContaCorrente {
    private String titular;
    private String identificador;
    private float saldo;
    private float limite;

    public ContaCorrente(String titular, String identificador, float limiteInicial){
        this.identificador = identificador;
        this.titular = titular;
        limite = limiteInicial;
    }

    public void setarIdentificador(String identificador){
        this.identificador = identificador;
    }

    public String obterIdentificador(){
        return identificador;
    }

    public void setarTitular(String titular){
        this.titular = titular;
    }

    public String obterTitular(){
        return titular;
    }

    public void setarLimite(float valor){
        this.limite = valor;
    }

    public void depositar(float valor){
        saldo += valor;
    }

    public boolean sacar(float valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        else if(valor <= saldo + limite){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String obterSaldo(){
        String retorno = "Saldo atual: "+saldo;
        retorno += "\nLimite de conta: "+limite;
        if(saldo<0)
            retorno += "\nLimite disponível: "+(limite+saldo);
        else
            retorno += "\nLimite disponível: "+limite;
        return retorno;
    }
}
