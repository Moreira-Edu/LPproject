package Interface;

import bancoClasses.Cliente;
import bancoClasses.Metodos;
import bancoClasses.excecoes;

import java.util.Scanner;

public class Interface {
    Metodos metodos = new Metodos();

    Cliente cliente;

    public void start() throws excecoes {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo(a)!");
        System.out.println("=====================================================");
        System.out.println(" INICIO:\n        Opção 1: Login | Opção 2: Cadastrar     ");
        System.out.println("=====================================================");

        try {
            int option = input.nextInt();
            if (option != 1 && option != 2) {
                System.out.println("Opção incorreta");
                start();
            } else {

                if (option == 1) {
                    System.out.println("=====================================================");
                    System.out.println("  LOGIN: \n                   Insira o CPF:         ");
                    System.out.println("=====================================================");
                    System.out.println(option);
                    String cpf = input.next();
                    cliente = metodos.login(cpf);
                    telaLogado();
                } else {
                    metodos.entrarDados();
                    start();

                }
            }

        } catch (Exception e) {
            System.out.println("Opção inváida");
            start();
        }


    }

    public void telaLogado() throws excecoes {
        Scanner input = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.println(" Olá, " + cliente.getNome().toUpperCase() + ":\n" +
                " Opção 1: Ver Saldo | Opção 2: Pagar | Opção 3: sair");
        System.out.println("=====================================================");
        int option = input.nextInt();

        if (option != 1 && option != 2 && option != 3) {
            System.out.println("Opção incorreta");
            telaLogado();
        } else {

            if (option == 1) {
                double saldoCredito = metodos.verSaldoCredito(cliente.getCpf());
                double saldo = metodos.verSaldo(cliente.getCpf());
                System.out.println("SALDO CONTA CORRENTE: R$" + saldo + "| Saldo Credito: R$" + saldoCredito);

                telaLogado();

            } else if (option == 2) {
                telaPagamento();
            } else {
                start();

            }
        }
    }

    public void telaPagamento() throws excecoes {
        Scanner input = new Scanner(System.in);
        System.out.println("========================================================================");
        System.out.println(" Olá, " + cliente.getNome().toUpperCase() + ":\n" +
                " Opção 1: Pagar com saldo Conta | Opção 2: Pagar com Credito | Opção 3: voltar");
        System.out.println("=========================================================================");
        int option = input.nextInt();

        if (option != 1 && option != 2 && option != 3) {
            System.out.println("Opção incorreta");
            telaPagamento();
        } else {

            if (option == 3) {
                telaLogado();
            }

            try {
                metodos.pagar(cliente.getCpf(), cliente.getNumBanco(), option);
                telaLogado();
            } catch (excecoes e) {
                System.out.println(e.getMessage());

                System.out.println("Tentar novamente? S/N");
                char c = input.next().charAt(0);
                while ((c != 'N' && c != 'n') && (c != 'S' && c != 's')) {
                    System.out.println(e.getMessage());
                    System.out.println("Tentar novamente? S/N");
                    c = input.next().charAt(0);
                }

                if (c == 'n' || c == 'N') {
                    telaLogado();
                } else {
                    metodos.pagar(cliente.getCpf(), cliente.getNumBanco(), option);
                    telaLogado();
                }

            }

        }
    }


}
