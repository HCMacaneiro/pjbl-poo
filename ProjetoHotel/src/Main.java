import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){
        // ! ALTERAR O CAMINHO DO ARQUIVO !
        String filePath = "C:\\Users\\diego\\Documents\\GitHub\\pjbl-poo\\ProjetoHotel\\src/hotel.txt";
        Scanner terminal = new Scanner(System.in);
        Hotel hotel = null;
        Funcionario funcionario;
        Cliente cliente;
        Quarto quarto;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Quarto> quartos = new ArrayList<Quarto>();

        System.out.println("\n[1] - Ler arquivo 'hotel'\n[2] - Criar novo perfil");
        int escolha = terminal.nextInt();

        switch (escolha) {
            // ler
            case 1:
                try {
                    FileInputStream fileIn = new FileInputStream(filePath);
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);
                    while (true) {
                        try {
                            Object obj = objIn.readObject(); // Read the object once

                            if (obj instanceof Hotel) {
                                hotel = (Hotel) obj;
                            } else if (obj instanceof Funcionario) {
                                funcionario = (Funcionario) obj;
                                funcionarios.add(funcionario);
                            } else if (obj instanceof Cliente) {
                                cliente = (Cliente) obj;
                                clientes.add(cliente);
                            } else if (obj instanceof Quarto) {
                                quarto = (Quarto) obj;
                                quartos.add(quarto);
                            } else {
                                break;
                            }
                        } catch (EOFException e) {
                            System.out.println("\nAVISO: leitura dos objetos bem sucedida!\n");
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("\n\nERRO: falha na leitura dos objetos:" + e.getMessage());
                }
                break;

                // criar
            case 2:
                try {
                    terminal.nextLine();
                    System.out.println("\nQual o nome do Hotel:");
                    String nome = terminal.nextLine();

                    hotel = new Hotel(nome);
                } catch (HotelException e) {
                    System.out.println(e);
                }

                int quantidade;
                mainFunctions funcoes = new mainFunctions();

                // # gerador de objetos #
                System.out.println("Quantos funcionários deseja adicionar:");
                quantidade = terminal.nextInt();
                funcionarios = funcoes.gerarFuncionario(quantidade);
                for (Funcionario f : funcionarios) {
                    hotel.adicionarFuncionario(f);
                }

                System.out.println("Quantos quartos deseja adicionar:");
                quantidade = terminal.nextInt();
                quartos = funcoes.gerarQuarto(quantidade);
                for (Quarto q : quartos) {
                    hotel.adicionarQuarto(q);
                }

                System.out.println("Quantos clientes deseja adicionar:");
                quantidade = terminal.nextInt();
                clientes = funcoes.gerarCliente(quantidade);
                for (Cliente c : clientes) {
                    System.out.println("Deseja adicionar o cliente'"+ c.getNome()+"' e CPF'"+ c.getCpf() +"' em qual dos quartos:");

                    int contador = 0;
                    for (Quarto q: quartos){
                        System.out.println("["+ contador +"] - "+ quartos.get(contador));
                    }

                    escolha = terminal.nextInt();
                    quarto = quartos.get(escolha);
                    quarto.adicionarHospede(c);
                }

                break;
        }

        // mostra o conteúdo de 'hotel'
        hotel.mostrarTudo();


        // persistir dados
        System.out.println("\n\nDeseja salvar os dados:\n[1] - Salvar\n[2] - Não Salvar");
        escolha = terminal.nextInt();

        switch (escolha) {
            case 1:
                // Salva o objeto hotel no arquivo .txt
                try {
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

                    objOut.writeObject(hotel);
                    for (Funcionario f : funcionarios){
                        objOut.writeObject(f);
                    }
                    for (Cliente c : clientes){
                        objOut.writeObject(c);
                    }
                    for (Quarto q : quartos){
                        objOut.writeObject(q);
                    }

                    System.out.println("O Hotel foi salvo.");
                } catch (IOException e) {
                    System.out.println("Um erro ocorreu ao salvar o Hotel: " + e.getMessage());
                }
                break;

            case 2:
                System.out.println("Opção 'Não Salvar' selecionada, saindo do programa...");
                break;
        }
    }
}
