package Aula23.exemploArquivo;

import java.io.*;

public class lerPessoa {

    public static void main(String[] args){
        File caminho = new File("C:\\Users\\Cimol\\Documents");
        File arquivo = new File(caminho, "pessoas.db");
        try{
            ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            Pessoa p1 = (Pessoa) objLeitura.readObject();
            System.out.println(p1);
            objLeitura.close();
        }
        catch(IOException e){
            System.out.println("Erro ao ler o arquivo ");
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro ao localizar a classe");
        }
    }

}
