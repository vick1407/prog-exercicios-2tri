
package aula24;
import java.io.*;
import java.util.Scanner;

public class Banco {

    private static final String ARQUIVO_PESSOAS = "pessoas.db";
    private static final String ARQUIVO_CONTAS_CORRENTES = "contas_correntes.db";
    private static final String ARQUIVO_CONTAS_POUPANCAS = "contas_poupancas.db";

    private static final int MAX_CONTAS = 20;
    private static final int MAX_PESSOAS = 10;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Pessoa[] listaPessoas = new Pessoa[MAX_PESSOAS];
        ContaCorrente[] listaCC = new ContaCorrente[MAX_CONTAS];
        ContaPoupanca[] listaCP = new ContaPoupanca[MAX_CONTAS];

        int contPessoas = 0;
        int contCC = 0;
        int contCP = 0;

        // Carregar pessoas do arquivo
        listaPessoas = leArquivoPessoas();

        String opc;
        do {
            exibirMenuPrincipal();
            opc = scanner.nextLine().toLowerCase();

            switch (opc) {
                case "cc":
                    if (contCC < MAX_CONTAS) {
                        listaCC[contCC++] = cadastraContaCorrente();
                    } else {
                        System.out.println("Limite máximo de contas correntes atingido!");
                    }
                    break;

                case "cp":
                    if (contCP < MAX_CONTAS) {
                        listaCP[contCP++] = cadastraContaPoupanca();
                    } else {
                        System.out.println("Limite máximo de contas poupanças atingido!");
                    }
                    break;

                case "ac":
                    acessarContaCorrente(listaCC, contCC);
                    break;

                case "ap":
                    acessarContaPoupanca(listaCP, contCP);
                    break;

                case "cpes":
                    cadastraPessoa(listaPessoas, contPessoas++);
                    break;

                case "lpes":
                    listarPessoas(listaPessoas, contPessoas);
                    break;

                case "e":
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (!opc.equals("e"));

        // Gravar pessoas no arquivo
        gravaArquivoPessoas(listaPessoas);

        // Gravar contas correntes e poupanças em arquivos separados
        gravaArquivoContas(listaCC, contCC, ARQUIVO_CONTAS_CORRENTES);
        gravaArquivoContas(listaCP, contCP, ARQUIVO_CONTAS_POUPANCAS);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n### MENU PRINCIPAL ###");
        System.out.println("cc - Cadastrar conta corrente");
        System.out.println("cp - Cadastrar conta poupança");
        System.out.println("ac - Acessar conta corrente");
        System.out.println("ap - Acessar conta poupança");
        System.out.println("cpes - Cadastrar pessoa");
        System.out.println("lpes - Listar pessoas");
        System.out.println("e - Sair");
        System.out.print("Opção: ");
    }

    private static ContaCorrente cadastraContaCorrente() {
        String titular = leString("Qual o titular da conta corrente");
        String senha = leString("Qual a senha");
        float limite = leFloat("Qual o limite inicial");
        return new ContaCorrente(titular, senha, limite);
    }

    private static ContaPoupanca cadastraContaPoupanca() {
        String titular = leString("Qual o titular da conta poupança");
        String senha = leString("Qual a senha");
        float depositoInicial = leFloat("Qual o valor do depósito inicial");
        return new ContaPoupanca(titular, senha, depositoInicial);
    }

    private static void acessarContaCorrente(ContaCorrente[] lista, int cont) {
        if (cont == 0) {
            System.out.println("Nenhuma conta corrente cadastrada.");
            return;
        }

        String identificador = leString("Qual o identificador da conta corrente");
        String senha = leString("Qual a senha");
        boolean encontrou = false;

        for (int i = 0; i < cont; i++) {
            if (lista[i].validaAcesso(identificador, senha)) {
                acessaCC(lista[i]);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Conta corrente não encontrada ou senha incorreta.");
        }
    }

    private static void acessarContaPoupanca(ContaPoupanca[] lista, int cont) {
        if (cont == 0) {
            System.out.println("Nenhuma conta poupança cadastrada.");
            return;
        }

        String identificador = leString("Qual o identificador da conta poupança");
        String senha = leString("Qual a senha");
        boolean encontrou = false;

        for (int i = 0; i < cont; i++) {
            if (lista[i].validaAcesso(identificador, senha)) {
                acessaCP(lista[i]);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Conta poupança não encontrada ou senha incorreta.");
        }
    }

    private static void cadastraPessoa(Pessoa[] lista, int cont) {
        if (cont < MAX_PESSOAS) {
            String nome = leString("Qual o nome da pessoa");
            String sobrenome = leString("Qual o sobrenome da pessoa");
            lista[cont] = new Pessoa(nome, sobrenome);
            System.out.println("Pessoa cadastrada com sucesso!");
        } else {
            System.out.println("Limite máximo de pessoas cadastradas atingido!");
        }
    }

    private static void listarPessoas(Pessoa[] lista, int cont) {
        if (cont == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("### LISTA DE PESSOAS CADASTRADAS ###");
            for (int i = 0; i < cont; i++) {
                System.out.println(lista[i]);
            }
        }
    }

    private static String leString(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    private static float leFloat(String mensagem) {
        System.out.print(mensagem + ": ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Valor inválido! Digite um número.");
            scanner.nextLine(); // Limpar o buffer
            System.out.print(mensagem + ": ");
        }
        float valor = scanner.nextFloat();
        scanner.nextLine(); // Limpar o buffer
        return valor;
    }

    private static void gravaArquivoPessoas(Pessoa[] lista) {
        try (ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PESSOAS))) {
            escrita.writeObject(lista);
            System.out.println("Pessoas gravadas no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar pessoas no arquivo: " + e.getMessage());
        }
    }

    private static Pessoa[] leArquivoPessoas() {
        Pessoa[] lista = new Pessoa[MAX_PESSOAS];
        try (ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(ARQUIVO_PESSOAS))) {
            lista = (Pessoa[]) leitura.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Arquivo de pessoas não encontrado ou erro ao ler: " + e.getMessage());
        }
        return lista;
    }

    private static void gravaArquivoContas(Conta[] lista, int cont, String arquivo) {
        try (ObjectOutputStream objEscrita = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            for (int i = 0; i < cont; i++) {
                objEscrita.writeObject(lista[i]);
            }
            System.out.println("Contas gravadas no arquivo " + arquivo + " com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar contas no arquivo " + arquivo + ": " + e.getMessage());
        }
    }

    private static void acessaCC(ContaCorrente conta) {
        String opc;
        do {
            System.out.println("\n### MENU CONTA CORRENTE ###");
            System.out.println("d - Realizar depósito");
            System.out.println("s - Realizar saque");
            System.out.println("v - Verificar saldo e limite");
            System.out.println("a - Alterar senha");
            System.out.println("e - Sair");
            opc = leString("Escolha uma opção").toLowerCase();

            switch (opc) {
                case "d":
                    float valorDeposito = leFloat("Qual valor deseja depositar");
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case "s":
                    float valorSaque = leFloat("Qual valor deseja sacar");
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo e limite insuficientes para realizar o saque.");
                    }
                    break;
                case "v":
                    System.out.println(conta.verificaSaldo());
                    break;
                case "a":
                    String novaSenha = leString("Qual a nova senha");
                    conta.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                    break;
                case "e":
                    System.out.println("Saindo da conta corrente...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (!opc.equals("e"));
    }

    private static void acessaCP(ContaPoupanca conta) {
        String opc;
        do {
            System.out.println("\n### MENU CONTA POUPANÇA ###");
            System.out.println("d - Realizar depósito");
            System.out.println("s - Realizar saque");
            System.out.println("v - Verificar saldo");
            System.out.println("a - Alterar senha");
            System.out.println("e - Sair");
            opc = leString("Escolha uma opção").toLowerCase();

            switch (opc) {
                case "d":
                    float valorDeposito = leFloat("Qual valor deseja depositar");
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case "s":
                    float valorSaque = leFloat("Qual valor deseja sacar");
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque.");
                    }
                    break;
                case "v":
                    System.out.println(conta.verificaSaldo());
                    break;
                case "a":
                    String novaSenha = leString("Qual a nova senha");
                    conta.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                    break;
                case "e":
                    System.out.println("Saindo da conta poupança...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (!opc.equals("e"));
    }
}
