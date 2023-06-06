import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class HotelManagement {
    private Hotel hotel;
    private HashMap<Integer, Hospede> checkIns;

    public HotelManagement(Hotel hotel) {
        this.hotel = hotel;
        this.checkIns = new HashMap<>();
    }

    public void checkIn(Hospede hospede, int numeroQuarto) throws QuartoOcupadoException {
        Quarto quarto = hotel.getQuartos().get(numeroQuarto - 1);
        if (quarto.isOcupado()) {
            throw new QuartoOcupadoException("O quarto " + numeroQuarto + " já está ocupado.");
        }
        quarto.ocupar();
        checkIns.put(numeroQuarto, hospede);
    }
    

    public void checkOut(int numeroQuarto) throws QuartoVazioException {
        Quarto quarto = hotel.getQuartos().get(numeroQuarto - 1);
        if (!quarto.isOcupado()) {
            throw new QuartoVazioException("O quarto " + numeroQuarto + " está vazio.");
        }
        quarto.desocupar();
    }
    

    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados_hotel.txt"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static HotelManagement carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados_hotel.txt"))) {
            return (HotelManagement) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return null;
        }
    }
    
}
