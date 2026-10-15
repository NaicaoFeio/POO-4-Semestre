// Classe que representa uma aplicação (container) rodando em um servidor. RA: 25201421-2
public class Container {

    // ID do container: identifica o container de forma única. RA: 25201421-2
    private String id;

    // Quantidade de RAM (em GB) que o container precisa para rodar. RA: 25201421-2
    private double ramNecessaria;

    // Construtor: guarda os dados recebidos nos atributos privados. RA: 25201421-2
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // Getter do ID. RA: 25201421-2
    public String getId() {
        return id;
    }

    // Setter do ID. RA: 25201421-2
    public void setId(String id) {
        this.id = id;
    }

    // Getter da RAM necessária (usado nos cálculos com Streams). RA: 25201421-2
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Setter da RAM necessária. RA: 25201421-2
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // equals: dois containers são iguais se tiverem o mesmo ID (RN01). RA: 25201421-2
    @Override
    public boolean equals(Object o) {
        // Mesmo objeto na memória: são iguais. RA: 25201421-2
        if (this == o) return true;
        // null ou classe diferente: não são iguais. RA: 25201421-2
        if (o == null || getClass() != o.getClass()) return false;
        // Converte para Container para comparar o ID. RA: 25201421-2
        Container outro = (Container) o;
        // A igualdade depende somente do ID. RA: 25201421-2
        return id.equals(outro.id);
    }

    // hashCode: usa o mesmo campo do equals (ID). RA: 25201421-2
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
