import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HotelGUI {
    private Hotel hotel;
    private JFrame frame;
    private JTextField nomeField, cpfField, telefoneField;
    private JTextArea textArea;

    public HotelGUI(Hotel hotel) {
        this.hotel = hotel;
        criarGUI();
    }

    private void criarGUI() {
        frame = new JFrame("Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField(20);

        JButton addHospedeButton = new JButton("Adicionar Hóspede");
        addHospedeButton.addActionListener(new AddHospedeListener());

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nomeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(cpfLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(telefoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 5, 5, 5);
        inputPanel.add(addHospedeButton, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new SaveListener());
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Carregar");
        loadButton.addActionListener(new LoadListener());
        buttonPanel.add(loadButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class AddHospedeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String telefone = telefoneField.getText();

            Hospede hospede = null;

            try {
                hospede = new Hospede(nome, cpf, telefone);
            } catch (HospedeException he){
                System.out.println(he.getMessage());
            }

            hotel.adicionarHospedeEmQuartoDisponivel(hospede);
            textArea.append("Hóspede adicionado: " + nome + "\n");

            nomeField.setText("");
            cpfField.setText("");
            telefoneField.setText("");
        }
    }

    private class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hotel.csv"));
                out.writeObject(hotel);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class LoadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("hotel.csv"));
                hotel = (Hotel) in.readObject();
                in.close();

                textArea.setText("");

                StringBuilder sb = new StringBuilder();
                sb.append("Quartos:\n");
                for (Quarto quarto : hotel.getQuartos()) {
                    sb.append("Quarto: " + quarto.getNumero() + " | ");
                    sb.append("Status: " + (quarto.isOcupado() ? "Ocupado" : "Vago") + " | ");
                    if (quarto.isOcupado()) {
                        sb.append("Hóspede: " + quarto.getHospede().getNome() + "\n");
                    } else {
                        sb.append("Hóspede: Nenhum\n");
                    }
                }

                textArea.append("Dados carregados com sucesso.\n" + sb.toString());
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Exemplo");
        new HotelGUI(hotel);
    }
}
