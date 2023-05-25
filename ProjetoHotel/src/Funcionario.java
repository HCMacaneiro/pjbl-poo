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
    public void mostrar() {
        super.mostrar();
        System.out.println("Salario: " + this.salario);
    }
}
