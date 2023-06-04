package pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import components.PageModel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPage extends PageModel{

    private JLabel loginLabel, passwordLabel, logoLabel;
    private ImageIcon logoIcon, scaledIcon;
    private Image scaledImage; 

    public JTextField raField, passwordField;
    public JButton loginButton, registerButton;
    public BorderLayout PageLayout = new BorderLayout(10, 10);

    public LoginPage() {
        super.superTitle = "Login";

        loginLabel = new JLabel("Login:");
        passwordLabel = new JLabel("Senha:");

        raField = new JTextField("", 30);
        passwordField = new JTextField("", 30);

        registerButton = new JButton("Cadastrar");
        loginButton = new JButton("Logar");

        EmptyBorder margin = new EmptyBorder(50, 0, 0, 0);
        // Image
        logoIcon = new ImageIcon("./assets/logoMaua.png");
        scaledImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImage);
        logoLabel = new JLabel(scaledIcon);
        logoLabel.setBorder(margin); 

        //Button Layout 
        Dimension buttonSize = new Dimension(110, 40);
        registerButton.setPreferredSize(buttonSize);
        loginButton.setPreferredSize(buttonSize);

        super.caixa.setLayout(new BorderLayout(10, 10));

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
        centerPanel.add(raField, gbc);
        gbc.gridy = 1;
        centerPanel.add(passwordField, gbc);

        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        super.menuBar.setVisible(false);
        
        super.caixa.add(centerPanel, BorderLayout.CENTER);
        super.caixa.add(buttonPanel, BorderLayout.SOUTH);
        super.caixa.add(logoLabel, BorderLayout.NORTH);
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public JButton getRegisterButton() {
        return this.registerButton;
    }

    public void actionPerformed(ActionEvent e) {

    }

}