package aula22.ExemploPolimorfismo;

public class Calculadora {
    public static void main(String[] args){
        Operacoes op = new Operacoes();
        System.out.println("Somando dois números: "+op.soma(5,6));
        System.out.println("Somando três números: "+op.soma(5,6,7)) ;
        System.out.println("Concatenando as strings: "+op.soma("rodrigo"," professor"));

    }

}
