import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioForm extends JFrame {
    private Funcionario funcionario;

    private JTextField fieldName;
    private JTextField fieldCPF;
    private JTextField fieldSalario;

    public FuncionarioForm() {
        createView();

        setTitle("Funcionario Form");
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

        JLabel labelSalario = new JLabel("Salario:");
        fieldSalario = new JTextField();
        panel.add(labelSalario);
        panel.add(fieldSalario);

        JButton buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFuncionario();
            }
        });
        panel.add(buttonSubmit);
    }

    private void createFuncionario() {
        String nome = fieldName.getText();
        String cpf = fieldCPF.getText();
        double salario = Double.parseDouble(fieldSalario.getText());

        funcionario = new Funcionario(nome, cpf, salario);

        JOptionPane.showMessageDialog(this,
                "Funcionario created: \nNome: " + funcionario.getNome() +
                        "\nCPF: " + funcionario.getCpf() +
                        "\nSalario: " + funcionario.getSalario());
    }
}