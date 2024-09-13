package aula32;

public class Lista {
    private String[] elementos;
    private int tamanho;

    public Lista(int capacidade) {
        elementos = new String[capacidade];
        tamanho = 0;
    }

    public void adiciona(String elemento) {
        if (tamanho < elementos.length)
            elementos[tamanho++] = elemento;
    }

    public void adiciona(int posicao, String elemento){
        if (posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição inválida");
        for (int i = tamanho;i > posicao;i--)
            elementos[i+1] = elementos[1];
        elementos[posicao] = elemento;
        tamanho++;
    }

    public String remove(int posicao){
        if(posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição inválida");
        String elemento = elementos[posicao];
        for (int i=posicao; i<tamanho-1; i++)
            elementos[i]= elementos[i+1];
        return elemento;
    }

    public int posicaoDe(String elemento) {
        for (int i = 0; i < tamanho; i++)
            if (elementos[i].equals(elemento))
                return i;
        return -1;
    }

    public String obterElemento(int posicao){
        if(posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição inválida");
        return elementos[posicao];
    }

    private void aumentaCapacidade(){
        if(tamanho==elementos.length){
            String[] aux = new String[tamanho *2];
            for(int i=0; i<elementos.length; i++)
                aux[i] = elementos[i];
            elementos = aux;
        }
    }

    @Override
    public String toString() {
        String resultado = "[";
        if (tamanho > 0) {
            for (int i = 0; i < tamanho - 1; i++)
                resultado += elementos[i] + ",";
            resultado += elementos[tamanho - 1];
        }
        return resultado + "]";
    }
}
