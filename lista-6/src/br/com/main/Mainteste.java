package br.com.main;

import br.com.model.Agencia;
import br.com.model.Cliente;
import br.com.model.ContaBancaria;

public class MainTeste {

    public static void main(String[] args) {

        // 1. Dois clientes diferentes, mesmo CPF
        Cliente cliente1 = new Cliente("111.222.333-44", "Ana Souza", "ana@email.com");
        Cliente cliente2 = new Cliente("111.222.333-44", "Ana S. Oliveira", "ana.oliveira@email.com");

        // 2. Teste de igualdade (RN02)
        if (cliente1.equals(cliente2)) {
            System.out.println("Clientes são iguais (mesmo CPF).");
        } else {
            System.out.println("ERRO: clientes deveriam ser iguais.");
        }

        // 3. Conta com saldo de 50.0
        ContaBancaria conta = new ContaBancaria("00123-4", cliente1, 50.0);

        // 4. Tentativa de saque de 50.0 (deve falhar por causa da taxa)
        boolean sucesso = conta.sacar(50.0);
        System.out.println("Saque de 50.0 realizado com sucesso? " + sucesso);
        System.out.println("Saldo atual: " + conta.getSaldo());

        // 5. Total de contas abertas na agência
        System.out.println("Total de contas abertas no " + Agencia.NOME_BANCO + ": "
                + Agencia.getTotalContasAbertas());
    }
}