import java.util.ArrayList;

public class Hotel {
    private String nome;
    private ArrayList<Quarto> quartos;

    public Hotel(String nome) {
        this.nome = nome;
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }
}
