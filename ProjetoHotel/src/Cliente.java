public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void apresentacao() {
        System.out.println("Olá, sou um cliente, meu nome é " + getNome());
    }
}
