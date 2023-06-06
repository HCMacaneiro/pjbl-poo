package myVersion;

public class TipoQuarto {
    private String nome;
    private double preco;
    private int capacidade;

    public TipoQuarto(String nome, double preco, int capacidade) {
        this.nome = nome;
        this.preco = preco;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
