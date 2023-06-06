import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HotelForm extends JFrame {
    private Hotel hotel;
    private JTextArea textArea;

    public HotelForm() throws HotelException{
        hotel = new Hotel("Adicionar Campo para Perguntar o nome");
        createView();

        setTitle("Hotel Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());

        JButton buttonShowQuartosDisponiveis = new JButton("Show Available Rooms");
        buttonShowQuartosDisponiveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Quarto> quartosDisponiveis = hotel.getQuartosDisponiveis();
                textArea.setText("");
                for (Quarto quarto : quartosDisponiveis) {
                    textArea.append(
                            "Room Number: " + quarto.getNumero() + ", Room Type: " + quarto.getTipo().getNome() + "\n");
                }
            }
        });
        panel.add(buttonShowQuartosDisponiveis, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
    }
}