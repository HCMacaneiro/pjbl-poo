public class Main {
    public static void main(String[] args) {
        try {
            // Criando um hotel
            Hotel hotel_pjbl = new Hotel("Hotel PJBL");

            // Criando quartos
            Quarto quarto101 = new Quarto(101);
            Quarto quarto102 = new Quarto(102);

            // Adicionando quartos ao hotel
            hotel_pjbl.adicionarQuarto(quarto101);
            hotel_pjbl.adicionarQuarto(quarto102);

            // Criando funcionários
            Funcionario funcionario1 = new Funcionario("João", "123456789", 5000.0,
                    "01/01/1980", "Rua 123, 456", "11223344", false);
            Funcionario funcionario2 = new Funcionario("Maria", "987654321", 6000.0,
                    "01/01/1970", "Rua 456, 123", "99887766", true);

            // Adicionando funcionários ao hotel
            hotel_pjbl.adicionarFuncionario(funcionario1);
            hotel_pjbl.adicionarFuncionario(funcionario2);

            // Criando clientes
            Cliente cliente1 = new Cliente("Carlos", "234567890", "carlos@example.com",
                    "Rua 789, 012", "22334455", "01/01/1990", true);
            Cliente cliente2 = new Cliente("Ana", "876543210", "ana@example.com",
                    "Rua 012, 789", "66778899", "01/01/1985", false);

            // Adicionando clientes ao quarto 101
            quarto101.adicionarHospede(cliente1);
            quarto101.adicionarHospede(cliente2);

            // Mostrando informações do hotel
            hotel_pjbl.mostrar();

            // Mostrando informações de cada funcionário
            funcionario1.mostrar();
            funcionario1.status();
            System.out.println("Salário do Funcionario 1: " + funcionario1.getSalario());

            funcionario2.mostrar();
            funcionario2.status();
            System.out.println("Salário do Funcionario 2: " + funcionario2.getSalario());

            // Alterando o nome do funcionario1
            funcionario1.setNome("João Silva");
            System.out.println("Novo nome do Funcionario 1: " + funcionario1.getNome());

            // Mostrando informações de cada cliente
            cliente1.mostrar();
            cliente1.status();
            System.out.println("Email do Cliente 1: " + cliente1.getEmail());

            cliente2.mostrar();
            cliente2.status();
            System.out.println("Email do Cliente 2: " + cliente2.getEmail());

            // Mostrando o número dos quartos
            System.out.println("Número do Quarto 101: " + quarto101.getNumero());
            System.out.println("Número do Quarto 102: " + quarto102.getNumero());

        } catch (HotelException e) {
            e.printStackTrace();
        }
    }
}

