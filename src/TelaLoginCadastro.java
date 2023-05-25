import javax.swing.*;
import java.awt.*;

public class TelaLoginCadastro extends JFrame {
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldSenha;

    public TelaLoginCadastro() {
        setTitle("Login e Cadastro");
        Dimension preferredSize = new Dimension(600, 400);
        setPreferredSize(preferredSize);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        add(centerPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 0, 10);

        JLabel labelLogin = new JLabel("Login:");
        centerPanel.add(labelLogin, gbc);

        gbc.gridy = 1;
        JLabel labelSenha = new JLabel("Senha:");

        centerPanel.add(labelSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 10);

        textFieldLogin = new JTextField(15);
        textFieldLogin.setPreferredSize(new Dimension(400, 24));
        centerPanel.add(textFieldLogin, gbc);

        gbc.gridy = 1;
        passwordFieldSenha = new JPasswordField(15);
        passwordFieldSenha.setPreferredSize(new Dimension(400, 24));
        centerPanel.add(passwordFieldSenha, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton registerButton = new JButton("Cadastrar");
        registerButton.setPreferredSize(new Dimension(110, 40));
        buttonPanel.add(registerButton);

        JButton loginButton = new JButton("Logar");
        loginButton.setPreferredSize(new Dimension(110, 40));
        buttonPanel.add(loginButton);

        pack();
        setLocationRelativeTo(null);

        ImageIcon logoIcon = new ImageIcon("logoMaua.png");
        Image scaledImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        add(logoLabel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro();
            telaLoginCadastro.setVisible(true);
        });
    }
}