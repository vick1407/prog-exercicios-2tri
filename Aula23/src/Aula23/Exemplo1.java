package Aula23;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Exemplo1 {
    public static int leNumero(String mensagem){
        Scanner ler = new Scanner (System.in);
        int num = 0;
        Boolean correto;
        do{
            try{
                System.out.print(mensagem);
                num = ler.nextInt();
                correto = true;
            }
            catch (InputMismatchException erro){
                correto = false;
                System.out.println("Os valores precisam ser números");
                ler.next();
            }
        }
        while (!correto);
        return num;
    }
    public static void main(String[] args) {
        int n1 = leNumero("Digite um número");
        int n2 = leNumero("Digite um número");
        try{
            Scanner ler = new Scanner(System.in);
            int resposta = n1/n2;
            System.out.println(resposta);

        }

        catch (ArithmeticException erro){
            System.out.println("Não é possível dividir por zero");
        }

    }
}
