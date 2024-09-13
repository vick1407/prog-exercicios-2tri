package aula32;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Lista l1 = new Lista(20);
        l1.adiciona("A");
        l1.adiciona("C");
        l1.adiciona("D");
        l1.adiciona("E");
        l1.adiciona("F");
        l1.adiciona("G");
        l1.adiciona("H");
        System.out.println(l1);
        System.out.println("Obtendo o elemento da posição 2" + l1.obterElemento(2));
        try {
            System.out.println("Obtendo o elemento da posição 10" + l1.obterElemento(10));
        }
        catch (IllegalArgumentException e){
            System.out.println("O elemnto 10, não existe na lista");
        }
        System.out.println("Posição do elemento 'A'? "+l1.posicaoDe("A"));
        System.out.println("Posição do elemento 'a'? "+l1.posicaoDe("a"));

    }


}