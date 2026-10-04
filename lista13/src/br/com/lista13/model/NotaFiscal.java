package br.com.lista13.model;

public class NotaFiscal implements IDocumento {
    @Override
    public void gerarPDF (){
        System.out.println("gerando nota fiscal com impostos");
    }
}
