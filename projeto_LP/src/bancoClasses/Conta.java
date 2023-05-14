package bancoClasses;

public class Conta {
    int numbanco;
    private double saldo;
    private double credito;
    private double saldoCredito;

    //getters
    public double getSaldo() {
        return saldo;
    }

    //setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(double saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public int getNumbanco() {
        return numbanco;
    }

    public void setNumbanco(int numbanco) {
        this.numbanco = numbanco;
    }

    public void cadastrarConta(double saldo, String typeConta, int numbanco) {
        setSaldo(saldo);
        setCredito(TypeConta.valueOf(typeConta).credit());
        setSaldoCredito(getCredito());
        setNumbanco(numbanco);
    }
}
