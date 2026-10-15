// Classe executável com o roteiro de testes do enunciado. RA: 25201421-2
public class MainCloud {

    // O main declara "throws" só porque alocarContainer lança uma exceção Checked; o programa não deve dar crash. RA: 25201421-2
    public static void main(String[] args) throws CapacidadeExcedidaException {

        // Passo 1: instancia o CloudManager. RA: 25201421-2
        CloudManager manager = new CloudManager();

        // Passo 2: instancia um cliente. RA: 25201421-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Passo 3: instancia um servidor (nasce desligado). RA: 25201421-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Passo 4: registra o cliente no banco e adiciona o servidor a ele. RA: 25201421-2
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // Passo 5: instancia dois containers diferentes. RA: 25201421-2
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // Passo 6: teste da falha Unchecked. Servidor desligado lança ServidorOfflineException. RA: 25201421-2
        // Já comentada para o programa poder prosseguir (passo 7). Descomente para ver o erro vermelho. RA: 25201421-2
        // servidor.alocarContainer(c1);

        // Passo 8: liga o servidor. RA: 25201421-2
        servidor.ligar();

        // Passo 9: aloca o Container 1 com sucesso (10.0 de 16.0 GB). RA: 25201421-2
        servidor.alocarContainer(c1);
        System.out.println("Container C-01 alocado com sucesso!");

        // Passo 10: teste da falha Checked, obrigatoriamente dentro de try-catch. RA: 25201421-2
        try {
            // 10.0 + 8.0 = 18.0 passa de 16.0, então deve lançar CapacidadeExcedidaException. RA: 25201421-2
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            // Captura a exceção e imprime a mensagem de forma elegante, sem crash. RA: 25201421-2
            System.out.println(e.getMessage());
        }

        // Passo 11: imprime a fatura ativa do cliente (servidor ligado = 5.50). RA: 25201421-2
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
