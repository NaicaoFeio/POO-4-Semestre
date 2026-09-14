package br.com.ecommerce.model;

public class FreteSedex extends EstrategiaFrete {
    @Override
    public double calcular(double valorPedido) {
        return valorPedido + valorPedido * 0.10;
    }
}
