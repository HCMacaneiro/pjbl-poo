import java.io.Serializable;

public class Quarto implements Serializable {
    private int numero;
    private String tipo;
    private boolean ocupado;
    private Hospede hospede;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
        this.ocupado = true;
    }

    public void removeHospede() {
        this.hospede = null;
        this.ocupado = false;
    }

    public Hospede getHospede() {
        return this.hospede;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupado() {
        return ocupado;
    }
}
