public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, String cargo, double salario) {
        super(nome, idade);
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Funcionário: " + this.nome + ", " + this.idade + ", " + this.cargo + ", " + this.salario);
    }
}