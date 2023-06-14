import java.util.ArrayList;
import java.util.Scanner;

public class mainFunctions {

    public ArrayList<Funcionario> gerarFuncionario(int quantidade){
        Scanner terminal = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for (int i = 0; i<quantidade; i++){
            System.out.println("\nQual o nome do Funcionario:");
            String nome = terminal.nextLine();

            System.out.println("\nQual seu CPF:");
            String cpf = terminal.nextLine();

            System.out.println("\nQual seu salario:");
            double salario = terminal.nextDouble();

            System.out.println("\nQual sua data de nascimento:");
            String dataNascimento = terminal.nextLine();

            System.out.println("\nQual seu endereço:");
            String endereco = terminal.nextLine();

            System.out.println("\nQual seu telefone:");
            String telefone = terminal.nextLine();

            System.out.println("\nSerá demitido:\n[1] - Sim\n[2] - Não");
            int aux = terminal.nextInt();
            boolean seraDemitido = aux != 2;

            Funcionario funcionarioNovo = new Funcionario(nome, cpf, salario, dataNascimento, endereco, telefone, seraDemitido);
            funcionarios.add(funcionarioNovo);
        }
        return funcionarios;
    }

    public ArrayList<Quarto> gerarQuarto(int quantidade){
        ArrayList<Quarto> quartos = new ArrayList<Quarto>();
        Scanner terminal = new Scanner(System.in);

        for (int i = 0; i < quantidade; i++){
            System.out.println("\nQual o número do quarto a ser adicionado:");
            int numero = terminal.nextInt();

            Quarto quartoNovo = new Quarto(numero);
            quartos.add(quartoNovo);
        }

        return quartos;
    }

    public ArrayList<Cliente> gerarCliente(int quantidade){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Scanner terminal = new Scanner(System.in);

        for (int i = 0; i < quantidade; i++){
            System.out.println("\nQual o nome do Cliente:");
            String nome = terminal.nextLine();

            System.out.println("\nQual seu CPF:");
            String cpf = terminal.nextLine();

            System.out.println("\nQual seu email:");
            String email = terminal.nextLine();

            terminal.nextLine();

            System.out.println("\nQual sua data de nascimento:");
            String dataNascimento = terminal.nextLine();

            System.out.println("\nQual seu endereço:");
            String endereco = terminal.nextLine();

            System.out.println("\nQual seu telefone:");
            String telefone = terminal.nextLine();

            System.out.println("\nEstá em um quarto:\n[1] - Sim\n[2] - Não");
            int aux = terminal.nextInt();
            boolean emQuarto = aux != 2;

            Cliente clienteNovo = new Cliente(nome, cpf, email, endereco, telefone, dataNascimento, emQuarto);
            clientes.add(clienteNovo);
        }

        return clientes;
    }

}
