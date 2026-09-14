package br.com.ecommerce.main;
import br.com.ecommerce.exception.FreteInvalidoException;
import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.EstrategiaFrete;
import br.com.ecommerce.model.FretePAC;
import br.com.ecommerce.model.FreteSedex;
import br.com.ecommerce.model.FreteMotoboy;

public class main {
    public static void main(String[] args) {

     CalculadoraFrete calculadora = new CalculadoraFrete();
     try{
   

        System.out.println(calculadora.ProcessarFrete(100.0, new FretePAC()));
        System.out.println(calculadora.ProcessarFrete(100.0, new FreteSedex()));
        System.out.println(calculadora.ProcessarFrete(100.0, new FreteMotoboy()));
        System.out.println(calculadora.ProcessarFrete(100.0,null));
        }
        catch(FreteInvalidoException e){
            System.out.println("Erro: " + e.getMessage());
        }

     }

        
}
