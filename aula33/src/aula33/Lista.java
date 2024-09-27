package aula33;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    public static void main(String[] args){
        List<String> lista = new ArrayList<>();
        lista.add("B");
        lista.add("D");
        lista.add("E");
        System.out.println(lista);
        lista.add(2,"C");
        System.out.println(lista);
        lista.add("G");
        lista.add("F");
        lista.add("D");
        lista.add("E");
        System.out.println();
    }
}
