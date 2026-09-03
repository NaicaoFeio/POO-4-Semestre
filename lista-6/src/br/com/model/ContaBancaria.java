package br.com.model;

public class ContaBancaria {

    private String numeroConta;
    private double saldo;
    private Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
        Agencia.registrarNovaConta();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        double totalNecessario = valor + Agencia.TAXA_SAQUE;
        if (saldo >= totalNecessario) {
            saldo -= totalNecessario;
            return true;
        }
        return false;
    }
}