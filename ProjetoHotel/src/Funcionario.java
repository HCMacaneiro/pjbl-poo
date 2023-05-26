public class Funcionario extends Pessoa {
    private double salario;
    private boolean seraDemitido;

    public Funcionario(String nome, String cpf, double salario, String dataNascimento, String endereco, String telefone, boolean seraDemitido) {
        super(nome, cpf, dataNascimento, endereco, telefone);
        this.salario = salario;
        this.seraDemitido = seraDemitido;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void status() {
        if(seraDemitido) {
            System.out.println("O funcionário será demitido.");
        } else {
            System.out.println("O funcionário não será demitido.");
        }
    }
}

