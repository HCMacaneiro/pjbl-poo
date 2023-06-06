import java.io.Serializable;
import java.util.ArrayList;

public class Quarto implements Serializable {
    private int numero;
    private ArrayList<Cliente> hospedes;

    public Quarto(int numero) {
        this.numero = numero;
        this.hospedes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void mostrar(){
        System.out.println("[ Quarto ]");
        System.out.println("Número: " + this.numero + "\n");
        for (Cliente c : hospedes){
            c.mostrar();
        }
    }

    public void adicionarHospede(Cliente cliente) {
        this.hospedes.add(cliente);
    }
}

