package br.com.lista13.main;

import br.com.lista13.model.DocumentoFactory;
import br.com.lista13.model.GerenciadorConfiguracao;
import br.com.lista13.model.IDocumento;

public class main {
  public static void main(String[] args){
   GerenciadorConfiguracao gen1 = GerenciadorConfiguracao.getInstance();
   System.out.println(gen1.getApiKey());
    GerenciadorConfiguracao gen2 = GerenciadorConfiguracao.getInstance();

    if(gen1 == gen2){
        System.out.println("mesma instancia");
    } else{
        System.out.println("instancias diferentes");
    }
     IDocumento nf = DocumentoFactory.criarDocumento("NF");
     nf.gerarPDF();
  
     try{
        IDocumento boleto = DocumentoFactory.criarDocumento("BOLETO");
        boleto.gerarPDF();
     } catch (IllegalArgumentException e){
        System.out.println("erro: " + e.getMessage());
     }
    }   

}
