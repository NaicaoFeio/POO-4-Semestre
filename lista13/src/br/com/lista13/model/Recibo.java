package br.com.lista13.model;

public class Recibo implements IDocumento {
    @Override
    public void gerarPDF() {
        System.out.println("gerando recibo simples de pagamento");
    }
}
