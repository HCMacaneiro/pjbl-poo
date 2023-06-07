import java.io.Serializable;

public class Quarto implements Serializable{
    private int numero;
    private String tipo;
    private boolean ocupado;

    public Quarto(int numero, String tipo, boolean ocupado) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = ocupado;
    }
    
    public void ocupar() {
        this.ocupado = true;
    }
    
    public void desocupar() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }
    public String toString(){
        return "Numero: "+ this.numero ;
    }

}

