// Exceção Checked (obriga try-catch ou throws): herda de Exception. RA: 25201421-2
public class CapacidadeExcedidaException extends Exception {

    // Construtor: repassa a mensagem de erro para a classe pai. RA: 25201421-2
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
