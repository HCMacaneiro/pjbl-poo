import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospedeForm extends JFrame {
    private Hospede hospede;

    private JTextField fieldName;
    private JTextField fieldCPF;
    private JTextField fieldTelefone;

    public HospedeForm() {
        createView();

        setTitle("Hospede Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new GridLayout(5, 2));

        JLabel labelName = new JLabel("Nome:");
        fieldName = new JTextField();
        panel.add(labelName);
        panel.add(fieldName);

        JLabel labelCPF = new JLabel("CPF:");
        fieldCPF = new JTextField();
        panel.add(labelCPF);
        panel.add(fieldCPF);

        JLabel labelTelefone = new JLabel("Telefone:");
        fieldTelefone = new JTextField();
        panel.add(labelTelefone);
        panel.add(fieldTelefone);

        JButton buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHospede();
            }
        });
        panel.add(buttonSubmit);
    }

    private void createHospede() {
        String nome = fieldName.getText();
        String cpf = fieldCPF.getText();
        String telefone = fieldTelefone.getText();

        hospede = new Hospede(nome, cpf, telefone);

        JOptionPane.showMessageDialog(this,
                "Hospede created: \nNome: " + hospede.getNome() +
                        "\nCPF: " + hospede.getCpf() +
                        "\nTelefone: " + hospede.getTelefone());
    }
}
