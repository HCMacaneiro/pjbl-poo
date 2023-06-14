import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private String nome;
    private ArrayList<Hospede> hospedes;
    private ArrayList<Quarto> quartos;

    public Hotel(String nome) {
        this.nome = nome;
        this.hospedes = new ArrayList<>();
        this.quartos = new ArrayList<>();

        // Inicializa 10 quartos
        for (int i = 1; i <= 10; i++) {
            this.quartos.add(new Quarto(i, "Simples"));
        }
    }

    public void adicionarHospedeEmQuartoDisponivel(Hospede hospede) {
        Quarto quartoDisponivel = null;
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                quartoDisponivel = quarto;
                break;
            }
        }

        if (quartoDisponivel != null) {
            quartoDisponivel.setHospede(hospede);
            hospedes.add(hospede);
        }
    }

    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }
}
