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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrar() {
        System.out.println(
        "Nome: " + this.nome + "\n" +
        "CPF: " + this.cpf + "\n" +
        "Data de Nascimento: " + this.dataNascimento + "\n" +
        "Endereço: " + this.endereco + "\n" +
        "Telefone: " + this.telefone
        );
    }

    
}
