import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable{
    private ArrayList<Quarto> quartos;

    public Hotel() {
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }

    public ArrayList<Quarto> getQuartos() {
        return this.quartos;
    }
}
