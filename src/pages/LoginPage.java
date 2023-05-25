package pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{

    private JLabel loginLabel, passwordLabel, logoLabel;
    private JTextField loginField, passwordField;
    private JButton loginButton, registerButton;
    private ImageIcon logoIcon, scaledIcon;
    private Image scaledImage; 

    public LoginPage() {
        super("Login e Cadastro");

        loginLabel = new JLabel("Login:");
        passwordLabel = new JLabel("Senha:");

        loginField = new JTextField("", 30);
        passwordField = new JTextField("", 30);

        registerButton = new JButton("Cadastrar");
        loginButton = new JButton("Logar");

        // Image
        logoIcon = new ImageIcon("./assets/logoMaua.png");
        scaledImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImage);
        logoLabel = new JLabel(scaledIcon);

        //Button Layout 
        Dimension buttonSize = new Dimension(110, 40);
        registerButton.setPreferredSize(buttonSize);
        loginButton.setPreferredSize(buttonSize);


        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout(10, 10));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Grid Layout
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(loginLabel, gbc);
        gbc.gridy = 1;
        centerPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(loginField, gbc);
        gbc.gridy = 1;
        centerPanel.add(passwordField, gbc);

        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        
        caixa.add(centerPanel, BorderLayout.CENTER);
        caixa.add(buttonPanel, BorderLayout.SOUTH);
        caixa.add(logoLabel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}