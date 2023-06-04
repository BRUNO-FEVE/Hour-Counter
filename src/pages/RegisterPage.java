package pages;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import components.PageModel;

public class RegisterPage extends PageModel{
    
    private JLabel nameLabel, raLabel, entityLabel, areaLabel, projectLabel, passwordLabel, confirmLabel;
    public JTextField nameField, raField, entityField, areaField, projectField;
    public JPasswordField passwordField, confirmField;
    public JButton registerButton;

    public RegisterPage() {
        super.superTitle = "Registri-se";

        nameLabel = new JLabel("Nome: ");
        raLabel = new JLabel("RA: ");
        entityLabel = new JLabel("Entidade: ");
        areaLabel = new JLabel("Área: ");
        projectLabel = new JLabel("Projeto: ");
        passwordLabel = new JLabel("Senha: ");
        confirmLabel = new JLabel("Comfirmar senha: ");

        nameField = new JTextField("", 20);
        raField = new JTextField("", 20);
        entityField = new JTextField("", 20);
        areaField = new JTextField("", 20);
        projectField = new JTextField("", 20);
        passwordField = new JPasswordField("", 20);
        confirmField = new JPasswordField("", 20);

        registerButton = new JButton("Cadastrar");

        // Layout 
        EmptyBorder padding = new EmptyBorder(15, 0, 15, 0);

        super.caixa.setLayout(new FlowLayout());

        JPanel columnPage = new JPanel(new GridLayout(2, 1)); 
        JPanel column = new JPanel(new GridLayout(8, 1));

        column.setBorder(padding);

        JPanel namePanel = new JPanel(new FlowLayout());
        JPanel raPanel = new JPanel(new FlowLayout());
        JPanel entityPanel = new JPanel(new FlowLayout());
        JPanel areaPanel = new JPanel(new FlowLayout());
        JPanel projectPanel = new JPanel(new FlowLayout());
        JPanel passwordPanel = new JPanel(new FlowLayout());
        JPanel confirmPanel = new JPanel(new FlowLayout());  
        JPanel buttomPanel = new JPanel(new FlowLayout());  
        
        JPanel nameRow = new JPanel(new BorderLayout());
        JPanel raRow = new JPanel(new BorderLayout());
        JPanel entityRow = new JPanel(new BorderLayout());
        JPanel areaRow = new JPanel(new BorderLayout());
        JPanel projectRow = new JPanel(new BorderLayout());
        JPanel passwordRow = new JPanel(new BorderLayout());
        JPanel confirmRow = new JPanel(new BorderLayout());

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        raPanel.add(raLabel);
        raPanel.add(raField);
        entityPanel.add(entityLabel);
        entityPanel.add(entityField);
        areaPanel.add(areaLabel);
        areaPanel.add(areaField);
        projectPanel.add(projectLabel);
        projectPanel.add(projectField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        confirmPanel.add(confirmLabel);
        confirmPanel.add(confirmField);
        buttomPanel.add(registerButton);

        nameRow.add(namePanel, BorderLayout.LINE_END);
        raRow.add(raPanel, BorderLayout.LINE_END);
        entityRow.add(entityPanel, BorderLayout.LINE_END);
        areaRow.add(areaPanel, BorderLayout.LINE_END);
        projectRow.add(projectPanel, BorderLayout.LINE_END);
        passwordRow.add(passwordPanel, BorderLayout.LINE_END);
        confirmRow.add(confirmPanel, BorderLayout.LINE_END);

        column.add(nameRow);
        column.add(raRow);
        column.add(entityRow);
        column.add(areaRow);
        column.add(projectRow);
        column.add(passwordRow);
        column.add(confirmRow);

        columnPage.add(column);
        columnPage.add(buttomPanel);

        super.menuBar.setVisible(false);

        super.caixa.add(columnPage);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
