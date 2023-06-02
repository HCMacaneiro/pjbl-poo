public class Main {
    public static void main(String[] args) {
        String fileName = "caminho/do/arquivo/file.txt";
        Hotel hotel = null;

        // Checa se o arquivo Existe
        boolean fileExists = new File(fileName).exists();

        // Lê o arquivo
        if (fileExists) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                hotel = (Hotel) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ocorreu um erro na leitura do arquivo: " + e.getMessage());
            }
        }

        // Caso o 'hotel' não exista, cria um novo
        if (!fileExists || hotel == null) {
            String nome;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nenhum objeto de 'hotel' encontrado, crie um...");
            System.out.println("Qual o nome do Hotel:");
            nome = scanner.nextLine();

            // Cria o Obj Hotel
            try {
                hotel = new Hotel(nome);
                System.out.println("Novo Hotel criado!");

                // Obj Quarto
                Quarto quarto101 = new Quarto(101);
                Quarto quarto102 = new Quarto(102);
                hotel.adicionarQuarto(quarto101);
                hotel.adicionarQuarto(quarto102);

                // Obj Funcionario
                Funcionario funcionario1 = new Funcionario("João", "123456789", 5000.0, "01/01/1980", "Rua 123, 456", "11223344", false);
                Funcionario funcionario2 = new Funcionario("Maria", "987654321", 6000.0, "01/01/1970", "Rua 456, 123", "99887766", true);
                hotel.adicionarFuncionario(funcionario1);
                hotel.adicionarFuncionario(funcionario2);

                // Obj Cliente
                Cliente cliente1 = new Cliente("Carlos", "234567890", "carlos@example.com", "Rua 789, 012", "22334455", "01/01/1990", true);
                Cliente cliente2 = new Cliente("Ana", "876543210", "ana@example.com", "Rua 012, 789", "66778899", "01/01/1985", false);
                quarto101.adicionarHospede(cliente1);
                quarto101.adicionarHospede(cliente2);
            } catch (HotelException e) {
                System.out.println("An error occurred while creating the hotel object: " + e.getMessage());
                return;
            }

            // Salva o objeto hotel no arquivo .txt
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                outputStream.writeObject(hotel);
                System.out.println("O Hotel foi salvo.");
            } catch (IOException e) {
                System.out.println("Um erro ocorreu ao salvar o Hotel: " + e.getMessage());
            }
        }
    }
}

