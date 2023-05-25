import java.util.ArrayList;

public class Hotel {
    private String nome;
    private ArrayList<Quarto> quartos;
    private ArrayList<Funcionario> funcionarios;

    public Hotel(String nome) {
        this.nome = nome;
        this.quartos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void mostrar() {
        System.out.println("Hotel: " + this.nome + "\n");
    }
}
