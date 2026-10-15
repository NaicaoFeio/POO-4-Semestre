import java.util.ArrayList;
import java.util.List;

// Classe que representa um servidor virtual da NexusCloud. RA: 25201421-2
public class Servidor {

    // IP do servidor: identifica o servidor de forma única. RA: 25201421-2
    private String ip;

    // Capacidade total de RAM do servidor (em GB). RA: 25201421-2
    private double ramTotal;

    // Preço cobrado por hora de uso do servidor (em R$). RA: 25201421-2
    private double precoPorHora;

    // Status do servidor: começa desligado (false). RA: 25201421-2
    private boolean statusLigado = false;

    // Lista cronológica de containers; já inicializada para evitar NullPointerException (RN02). RA: 25201421-2
    private List<Container> containers = new ArrayList<>();

    // Construtor: recebe IP, RAM total e preço; o status e a lista já têm valor inicial. RA: 25201421-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
    }

    // Liga o servidor, mudando o status para true. RA: 25201421-2
    public void ligar() {
        this.statusLigado = true;
    }

    // Desliga o servidor, mudando o status para false. RA: 25201421-2
    public void desligar() {
        this.statusLigado = false;
    }

    // Aloca um container no servidor aplicando a política Fail-Fast (RN03). RA: 25201421-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {

        // Regra de Status (Unchecked): servidor desligado não aceita containers. RA: 25201421-2
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }

        // Soma a RAM que já está em uso com a RAM do novo container. RA: 25201421-2
        double ramDepois = calcularRamEmUso() + c.getRamNecessaria();

        // Regra de Capacidade (Checked): não pode ultrapassar a RAM total do servidor. RA: 25201421-2
        if (ramDepois > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }

        // Passou nas duas validações: agora sim adiciona o container na lista. RA: 25201421-2
        containers.add(c);
    }

    // Calcula a RAM em uso somando a ramNecessaria de todos os containers, usando Streams (RN04). RA: 25201421-2
    public double calcularRamEmUso() {
        return containers.stream()                         // transforma a lista em um fluxo de containers RA: 25201421-2
                .mapToDouble(Container::getRamNecessaria)  // extrai só a RAM de cada container RA: 25201421-2
                .sum();                                    // soma todos os valores RA: 25201421-2
    }

    // Getter do IP. RA: 25201421-2
    public String getIp() {
        return ip;
    }

    // Setter do IP. RA: 25201421-2
    public void setIp(String ip) {
        this.ip = ip;
    }

    // Getter da RAM total. RA: 25201421-2
    public double getRamTotal() {
        return ramTotal;
    }

    // Setter da RAM total. RA: 25201421-2
    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    // Getter do preço por hora (usado no cálculo da fatura). RA: 25201421-2
    public double getPrecoPorHora() {
        return precoPorHora;
    }

    // Setter do preço por hora. RA: 25201421-2
    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    // Getter do status (boolean usa "is" por convenção); usado no filter da fatura. RA: 25201421-2
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // Getter da lista de containers. RA: 25201421-2
    public List<Container> getContainers() {
        return containers;
    }

    // equals: dois servidores são iguais se tiverem o mesmo IP (RN01). RA: 25201421-2
    @Override
    public boolean equals(Object o) {
        // Mesmo objeto na memória: são iguais. RA: 25201421-2
        if (this == o) return true;
        // null ou classe diferente: não são iguais. RA: 25201421-2
        if (o == null || getClass() != o.getClass()) return false;
        // Converte para Servidor para comparar o IP. RA: 25201421-2
        Servidor outro = (Servidor) o;
        // A igualdade depende somente do IP. RA: 25201421-2
        return ip.equals(outro.ip);
    }

    // hashCode: usa o mesmo campo do equals (IP). RA: 25201421-2
    @Override
    public int hashCode() {
        return ip.hashCode();
    }
}
