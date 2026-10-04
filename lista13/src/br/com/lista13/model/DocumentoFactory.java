package br.com.lista13.model;

public class DocumentoFactory {
    public static IDocumento criarDocumento(String tipo) {
        if (tipo.equals("NF")) {
            return new NotaFiscal();
        } else if (tipo.equals("recibo")) {
            return new Recibo();
        } else {
            throw new IllegalArgumentException("documento inválido " + tipo);
        }
    }
}