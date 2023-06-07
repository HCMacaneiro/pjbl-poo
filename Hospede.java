public class Hospede extends Pessoa {
    private int quarto;
    private double conta;
    
    public Hospede(String nome, int idade, int quarto) {
        super(nome, idade);
        this.quarto = quarto;
        this.conta = 0;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Hóspede: " + this.nome + ", " + this.idade + ", " + this.quarto);
    }

    public void adicionarConta(double valor) {
        this.conta += valor;
    }

    public void pagarConta() {
        System.out.println("Conta paga: " + this.conta);
        this.conta = 0;
    }
}