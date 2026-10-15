// Exceção Unchecked (não obriga try-catch): herda de RuntimeException. RA: 25201421-2
public class ServidorOfflineException extends RuntimeException {

    // Construtor: repassa a mensagem de erro para a classe pai. RA: 25201421-2
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}
