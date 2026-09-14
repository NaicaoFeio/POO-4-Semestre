package br.com.ecommerce.model;

public class FreteMotoboy extends EstrategiaFrete {
    @Override
    public double calcular(double valorPedido) {
        return valorPedido + 15.00;
    }
}    

