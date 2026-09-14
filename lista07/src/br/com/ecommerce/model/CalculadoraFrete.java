package br.com.ecommerce.model;

import br.com.ecommerce.exception.FreteInvalidoException;

public class CalculadoraFrete {
    public double ProcessarFrete(double valorPedido, EstrategiaFrete estrategiaFrete){
            if(estrategiaFrete == null){
                throw new FreteInvalidoException("deu red chefe");
            }
            else{
                double valorFrete = estrategiaFrete.calcular(valorPedido);
                return valorFrete;
            }
    }
}
