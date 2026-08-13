package br.com.meusistema.main;

import br.com.meusistema.model.Carro;
public class Sistema {
public static void main(String[] args) {
System.out.println("Iniciando o sistema...");

Carro meuCarro = new Carro();
Carro meuCarro2 = new Carro();
meuCarro.modelo = "Fusca";
meuCarro.cor = "Azul";

meuCarro2.modelo = "Civic";
meuCarro2.cor = "Prata";
meuCarro.buzinar();
meuCarro2.buzinar();
}
}