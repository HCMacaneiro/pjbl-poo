public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void apresentacao() {
        System.out.println("Olá, sou um funcionário, meu nome é " + getNome());
    }
}
