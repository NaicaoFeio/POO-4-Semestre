package br.com.ecommerce.model;

public class FretePAC extends EstrategiaFrete {
    @Override
    public double calcular(double valorPedido) {
        return valorPedido + valorPedido * 0.5;
    }
    
}
