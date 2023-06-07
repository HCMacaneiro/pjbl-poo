import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelGUI extends JFrame {

    private HotelManagement hotelManagement;

    private JTextField nomeHospedeField;
    private JTextField idadeHospedeField;
    private JTextField numeroQuartoField;
    private JButton checkInButton;
    private JButton checkOutButton;
    private JButton saveButton;
    private JButton loadButton;

    public HotelGUI() {
        this.hotelManagement = new HotelManagement(new Hotel());

        this.nomeHospedeField = new JTextField("Nome do hóspede");
        this.idadeHospedeField = new JTextField("Idade do hóspede");
        this.numeroQuartoField = new JTextField("Número do quarto");
        this.checkInButton = new JButton("Check In");
        this.checkOutButton = new JButton("Check Out");
        this.saveButton = new JButton("Save");
        this.loadButton = new JButton("Load");

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeHospede = nomeHospedeField.getText();
                int idadeHospede = Integer.parseInt(idadeHospedeField.getText());
                int numeroQuarto = Integer.parseInt(numeroQuartoField.getText());

                try {
                    hotelManagement.checkIn(new Hospede(nomeHospede, idadeHospede, numeroQuarto), numeroQuarto);
                } catch (QuartoOcupadoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroQuarto = Integer.parseInt(numeroQuartoField.getText());

                try {
                    hotelManagement.checkOut(numeroQuarto);
                } catch (QuartoVazioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hotelManagement.salvarDados();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hotelManagement = HotelManagement.carregarDados();
                hotelManagement.mostrarHotel();
            }
        });

        this.add(nomeHospedeField);
        this.add(idadeHospedeField);
        this.add(numeroQuartoField);
        this.add(checkInButton);
        this.add(checkOutButton);
        this.add(saveButton);
        this.add(loadButton);

        this.setSize(300, 200);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HotelGUI();

            }
        });
    }
}