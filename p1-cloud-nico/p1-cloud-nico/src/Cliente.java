// Classe que representa um cliente da NexusCloud. RA: 25201421-2
public class Cliente {

    // CPF do cliente: é o dado que identifica o cliente de forma única. RA: 25201421-2
    private String cpf;

    // Nome do cliente (ou da empresa). RA: 25201421-2
    private String nome;

    // Construtor: recebe os dados e guarda nos atributos privados. RA: 25201421-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getter do CPF: permite ler o valor do atributo privado. RA: 25201421-2
    public String getCpf() {
        return cpf;
    }

    // Setter do CPF: permite alterar o valor do atributo privado. RA: 25201421-2
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter do nome. RA: 25201421-2
    public String getNome() {
        return nome;
    }

    // Setter do nome. RA: 25201421-2
    public void setNome(String nome) {
        this.nome = nome;
    }

    // equals: dois clientes são iguais se tiverem o mesmo CPF (RN01). RA: 25201421-2
    @Override
    public boolean equals(Object o) {
        // Se for o mesmo objeto na memória, já são iguais. RA: 25201421-2
        if (this == o) return true;
        // Se for null ou de outra classe, não são iguais. RA: 25201421-2
        if (o == null || getClass() != o.getClass()) return false;
        // Converte o objeto para Cliente para poder comparar o CPF. RA: 25201421-2
        Cliente outro = (Cliente) o;
        // A igualdade depende somente do CPF. RA: 25201421-2
        return cpf.equals(outro.cpf);
    }

    // hashCode: precisa usar o mesmo campo do equals (CPF), senão o HashMap quebra. RA: 25201421-2
    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}
