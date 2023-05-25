public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String cpf, String email, String endereco, String telefone, String dataNascimento) {
        super(nome, cpf, endereco, telefone, dataNascimento);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Olá, sou um cliente, meu nome é " + getNome();
    }
}
