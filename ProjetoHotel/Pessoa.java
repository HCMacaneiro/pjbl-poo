import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public abstract void mostrarDados();
}