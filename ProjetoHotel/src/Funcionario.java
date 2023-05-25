public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, String cpf, double salario, String dataNascimento, String endereco, String telefone) {
        super(nome, cpf, dataNascimento, endereco, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + this.salario;
    }
}
