import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private String email;
    private boolean emQuarto;

    public Cliente(String nome, String cpf, String email, String endereco, String telefone, String dataNascimento, boolean emQuarto) {
        super(nome, cpf, dataNascimento, endereco, telefone);
        this.email = email;
        this.emQuarto = emQuarto;
    }

    public String getEmail() {
        return email;
    }

    public void mostrar(){
        System.out.println("[ Cliente ]");
        super.mostrar();

        System.out.println("Email: " + this.email + "\n" +
                            "Em Quarto: " + this.emQuarto + "\n");
    }

    @Override
    public void status() {
        if(emQuarto) {
            System.out.println("O cliente está em um quarto.");
        } else {
            System.out.println("O cliente não está em um quarto.");
        }
    }
}
