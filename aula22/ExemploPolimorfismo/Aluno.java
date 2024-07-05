package aula22.ExemploPolimorfismo;

public class Aluno extends Pessoa{
    String matricula;
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula (String matricula){
        this.matricula= matricula;
    }
    @Override
    public String obterDados(){
        return "Nome"+getNome()+" Sobrenome:"+getSobrenome()+"Matrícula:"+matricula;
    }
    @Override
    public String toString(){
        return obterDados();
    }
}
