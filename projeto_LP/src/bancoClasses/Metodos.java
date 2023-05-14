package bancoClasses;

import java.util.Scanner;

public class Metodos {
    Banco banco = new Banco();

    public static void mostrarCliente(Banco banco, int i) {

        System.out.print(banco.getClientes().get(i).getContaType() + "\n");
        System.out.print(banco.getClientes().get(i).getCpf() + "\n");
        System.out.print(banco.getContas().get(i).getSaldoCredito() + "\n");
    }

    public Cliente login(String cpf) throws excecoes {
        return this.banco.getClient(cpf);
    }

    public void entrarDados() throws excecoes {
        Cliente cliente = new Cliente();
        Conta conta = new Conta();
        Scanner sc = new Scanner(System.in);
        System.out.println("escreva seu name");
        String name = sc.next();
        System.out.println("insira seu cpf");
        String cpf = sc.next();
        System.out.println("insira seu tipo de conta");
        String typeConta = sc.next();
        System.out.println("saldo da conta");
        double saldo = sc.nextDouble();
        cliente.criarCliente(name, typeConta, cpf);
        conta.cadastrarConta(saldo, typeConta, cliente.getNumBanco());
        this.banco.addClient(cliente, conta);

        if (banco.getClient(cpf) != null) {
            System.out.println("Conta adicionada com sucesso!");
        }

    }

    public double verSaldo(String cpf) throws excecoes {
        int numbanco = banco.getClient(cpf).getNumBanco();
        return banco.getConta(banco.getClient(cpf).getNumBanco(), cpf).getSaldo();
    }

    public double verSaldoCredito(String cpf) throws excecoes {
        int numbanco = banco.getClient(cpf).getNumBanco();
        return banco.getConta(banco.getClient(cpf).getNumBanco(), cpf).getSaldoCredito();
    }

    public boolean validarCpf(Cliente cliente, String cpf) {
        if (cliente.getCpf().equals(cpf)) {
            return true;
        }
        return false;
    }

    public boolean validarNome(Cliente cliente, String name) {
        if (cliente.getNome().equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }

    public boolean validarNome(Cliente cliente, int numBanco) {
        if (cliente.getNumBanco() == numBanco) {
            return true;
        }
        return false;
    }

    public void pagar(String cpf, int NumBanco, int option) throws excecoes {
        Scanner input = new Scanner(System.in);
        Conta conta = banco.getConta(NumBanco, cpf);

        System.out.print("Insira o valor R$: ");
        double value = input.nextDouble();
        double credit = conta.getSaldoCredito();
        double saldo = conta.getSaldo();


        if (option == 1) {
            if (value > saldo) {
                throw new excecoes("Saldo insuficiente.\n" + "Saldo atual: " + saldo);
            }
            conta.setSaldo(saldo - value);

            System.out.println("Pagamento realizado com sucesso! \n" +
                    "Saldo atual: " + conta.getSaldo());
        } else {
            if (value > credit) {
                throw new excecoes("Saldo insuficiente.\n" + "Crédito atual: " + credit);
            }
            conta.setSaldoCredito(credit - value);

            System.out.println("Pagamento realizado com sucesso! \n" +
                    "Saldo atual: " + conta.getSaldoCredito());
        }

    }
}
