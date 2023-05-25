public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String cpf, String dataNascimento, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return
            "\n\nNome: " + this.nome +
            "\nCPF: " + this.cpf +
            "\nData de Nascimento: " + this.dataNascimento +
            "\nEndereço: " + this.endereco +
            "\nTelefone: " + this.telefone;
    }

    
}
