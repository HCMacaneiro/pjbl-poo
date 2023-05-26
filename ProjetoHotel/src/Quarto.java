import java.util.ArrayList;

public class Quarto {
    private int numero;
    private ArrayList<Cliente> hospedes;

    public Quarto(int numero) {
        this.numero = numero;
        this.hospedes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarHospede(Cliente cliente) {
        this.hospedes.add(cliente);
    }
}

