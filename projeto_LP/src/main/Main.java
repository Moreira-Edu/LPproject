package main;

import Interface.Interface;
import bancoClasses.Banco;
import bancoClasses.excecoes;

public class Main {


    public static void main(String[] args) throws excecoes {
        Interface menu = new Interface();
        try {
            menu.start();
        } catch (Exception e) {
            System.out.println("Erro interno: " + e.getMessage() + "\nreiniciando");
            menu.start();
        }

    }

    public static void mostrarCliente(Banco banco, int i) {

        System.out.print(banco.getClientes().get(i).getContaType() + "\n");
        System.out.print(banco.getClientes().get(i).getCpf() + "\n");
        System.out.print(banco.getContas().get(i).getSaldoCredito() + "\n");
        System.out.print(banco.getContas().get(i).getSaldo() + "\n");
    }

}
