package myVersion;

public class Quarto {
    private int numero;
    private TipoQuarto tipo;
    private StatusQuarto status;

    public Quarto(int numero, TipoQuarto tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.status = StatusQuarto.DISPONIVEL;
    }

    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }
}
