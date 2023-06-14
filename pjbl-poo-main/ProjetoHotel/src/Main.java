import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // ! ALTERAR O CAMINHO DO ARQUIVO !
        String fileName = "C:\\Users\\diego\\Downloads\\pjbl-poo-main\\pjbl-poo-main\\ProjetoHotel\\src\\hotel.txt";
        Object object = null;
        ArrayList<Object> obj = new ArrayList<Object>();
        Hotel hotel = null;

        Scanner terminal = new Scanner(System.in);

        // Checa se o arquivo Existe
        boolean fileExists = new File(fileName).exists();

        // Lê o arquivo
        if (fileExists) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                object = inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("\n\nERRO: erro na leitura do arquivo: " + e.getMessage());
            }
        }


        System.out.println("\n[1] - Ler arquivo 'hotel'\n[2] - Criar novo perfil");
        int escolha = terminal.nextInt();

        // verifica se 'hotel' existe no .txt
        if (!fileExists || object == null && escolha == 1) {
            System.out.println("\n\nERRO: o objeto 'hotel' não existe, vamos criar um novo perfil...\n");
            escolha = 2;
        }

        switch (escolha) {
            case 1:
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                    while (true) {
                        try {
                            // captura todos os objetos do arquivo
                            object = inputStream.readObject();
                            System.out.println(object);

                            // começa a separação dos objetos
                            if (object instanceof Hotel) {
                                hotel = (Hotel) object;

                            } else if (object instanceof Funcionario) {
                                Funcionario funcionario = (Funcionario) object;

                            } else if (object instanceof Cliente) {
                                Cliente cliente = (Cliente) object;

                            }
                            // aciona ao chegar no final do arquivo
                        } catch (EOFException e) {
                            System.out.println("\nAVISO: leitura dos objetos bem sucedida!\n");
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("\n\nERRO: falha na leitura dos objetos:" + e.getMessage());
                }
                break;

            case 2:
                terminal.nextLine();
                try {
                    System.out.println("\nQual o nome do Hotel:");
                    String nome = terminal.nextLine();

                    hotel = new Hotel(nome);
                } catch (HotelException e) {
                    System.out.println(e);
                }
                obj.add(hotel);

                int quantidade;
                mainFunctions funcoes = new mainFunctions();

                // # gerador de objetos #
                System.out.println("Quantos funcionários deseja adicionar:");
                quantidade = terminal.nextInt();
                ArrayList<Funcionario> funcionarios = funcoes.gerarFuncionario(quantidade);
                for (Funcionario f : funcionarios) {
                    hotel.adicionarFuncionario(f);
                    obj.add(f);
                }

                System.out.println("Quantos quartos deseja adicionar:");
                quantidade = terminal.nextInt();
                ArrayList<Quarto> quartos = funcoes.gerarQuarto(quantidade);
                for (Quarto q : quartos) {
                    hotel.adicionarQuarto(q);
                    obj.add(q);
                }

                System.out.println("Quantos clientes deseja adicionar:");
                quantidade = terminal.nextInt();
                ArrayList<Cliente> clientes = funcoes.gerarCliente(quantidade);
                for (Cliente c : clientes) {
                    obj.add(c);
                    System.out.println("Deseja adicionar o cliente'"+ c.getNome()+"' e CPF'"+ c.getCpf() +"' em qual dos quartos:");

                    int contador = 0;
                    for (Quarto q: quartos){
                        System.out.println("["+ contador +"] - "+ quartos.get(contador));
                    }

                    escolha = terminal.nextInt();
                    Quarto quarto = quartos.get(escolha);
                    quarto.adicionarHospede(c);
                }

                break;
        }

        // mostra o conteúdo de 'hotel'
        hotel.mostrarTudo();

        // persistir dados
        System.out.println("Deseja salvar os dados:\n[1] - Salvar\n[2] - Não Salvar");
        escolha = terminal.nextInt();

        switch (escolha) {
            case 1 -> {
                // Salva o objeto hotel no arquivo .txt
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    outputStream.writeObject(obj);
                    System.out.println("O Hotel foi salvo.");
                } catch (IOException e) {
                    System.out.println("Um erro ocorreu ao salvar o Hotel: " + e.getMessage());
                }
            }
            case 2 -> System.out.println("Opção 'Não Salvar' selecionada, saindo do programa...");
        }
    }
}