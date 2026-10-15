import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Classe que funciona como o banco de dados principal da NexusCloud. RA: 25201421-2
public class CloudManager {

    // Mapa baseado em Hash: chave = Cliente, valor = conjunto de Servidores (sem repetição e sem ordem) (RN02). RA: 25201421-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra um cliente no banco com um conjunto de servidores vazio. RA: 25201421-2
    public void registrarCliente(Cliente c) {
        bancoDeDados.put(c, new HashSet<>());
    }

    // Adiciona um servidor ao conjunto de servidores de um cliente já registrado. RA: 25201421-2
    public void adicionarServidor(Cliente c, Servidor s) {
        bancoDeDados.get(c).add(s);
    }

    // Calcula a fatura somando o preço por hora dos servidores LIGADOS do cliente, com Streams (RN04). RA: 25201421-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, new HashSet<>()) // pega os servidores do cliente (vazio se não existir) RA: 25201421-2
                .stream()                                    // transforma o conjunto em um fluxo RA: 25201421-2
                .filter(Servidor::isStatusLigado)            // deixa passar APENAS servidores ligados RA: 25201421-2
                .mapToDouble(Servidor::getPrecoPorHora)      // extrai o preço por hora de cada um RA: 25201421-2
                .sum();                                      // soma tudo e retorna RA: 25201421-2
    }

    // Getter do banco de dados. RA: 25201421-2
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }
}
