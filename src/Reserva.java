import java.io.Serializable;

public class Reserva implements Serializable {
    private Quarto quarto;
    private Hospede hospede;

    public Reserva(Quarto quarto, Hospede hospede) {
        this.quarto = quarto;
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return this.quarto;
    }

    public Hospede getHospede() {
        return this.hospede;
    }
}
