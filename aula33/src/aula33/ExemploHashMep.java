package aula33;

import java.util.HashMap;

public class ExemploHashMep {
    public static void main(String[] args){
        HashMap<String, String> capitais = new HashMap<>();
        capitais.put("SC","Santa Catarina");
        capitais.put("RS","Rio Grande do Sul");
        capitais.put("PA","Parana");
        System.out.println(capitais);
        for (String estado:capitais.keySet())
            System.out.println(estado+"");
        for (String cidade:capitais.values())
            System.out.println(cidade+"");
        System.out.println("\nA lista contém uma chave 'RS'?"+capitais.containsKey("RS"));
        System.out.println("\nA lista contém uma chave 'Porto Alegre'?"+capitais.containsKey("Porto Alegre"));
    }
}
