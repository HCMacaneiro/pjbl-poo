import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private String nome;
    private ArrayList<Quarto> quartos;
    private ArrayList<Funcionario> funcionarios;

    public Hotel(String nome) throws HotelException {
        if (nome == null || nome.equals("")) {
            throw new HotelException("Nome do hotel não pode ser vazio");
        }

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

    public void mostrarTudo(){
        System.out.println("[ Hotel ]");
        System.out.println("Hotel: " + this.nome + "\n");

        for (Funcionario f : funcionarios){
            f.mostrar();
        }

        for (Quarto q : quartos){
            q.mostrar();
        }

    }
}

