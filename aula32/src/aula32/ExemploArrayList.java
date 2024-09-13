import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args){
        ArrayList<String> lista = new ArrayList<>(10);
        lista.add("A");
        lista.add("C");
        lista.add("D");
        lista.add("E");
        lista.add("F");
        lista.add("G");
        System.out.println(lista);
        lista.add(1,"B");
        System.out.println(lista);
        if(lista.contains("A")){
            System.out.println("o elemento A existe na lista ");
        }
        else{
            System.out.println("o elemento A nao existe na lista ");
        }
        System.out.println("a posição do elemento 'C' na lista "+lista.indexOf("C"));
        lista.add("C");
        System.out.println(lista);
        System.out.println("a ultima posição 'C' na lista "+lista.lastIndexOf("C"));
        System.out.println("removendo o elemento "+lista.remove(1));
        System.out.println("removendo o elemento "+lista.remove("D"));

        System.out.println("obtendo o elemento da posição 2 "+lista.get(2));
        System.out.println("o tamanho da lista é"+lista.size());
        lista.clear();
        System.out.println(lista);
        System.out.println("a lista esta vazia "+lista.isEmpty());

    }
}