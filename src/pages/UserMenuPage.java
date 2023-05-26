package pages;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserMenuPage extends JFrame implements ActionListener{
    
    private JLabel message, nameData, raData, entityData, areaData, projectData ,userNameLabel, userRaLabel, userEntityLabel, userAreaLabel, userProjectLabel;
    private JButton registerHourButton, showHourButton;

    public UserMenuPage() {
        super("User Menu");

        message = new JLabel("Seus Dados:");
        userNameLabel = new JLabel("Nome:");
        userRaLabel = new JLabel("RA:");
        userEntityLabel = new JLabel("Entidade:");
        userAreaLabel = new JLabel("Área:");
        userProjectLabel = new JLabel("Projeto:");

        nameData = new JLabel("User.getName()");
        raData = new JLabel("User.getRa()");
        entityData = new JLabel("User.getEntity()");
        areaData = new JLabel("User.getArea()");
        projectData = new JLabel("User.getProject()");

        registerHourButton = new JButton("Registrar Horas");
        showHourButton = new JButton("Visualizar Horas");

        // Layout

        EmptyBorder paddingUserData = new EmptyBorder(10, 30, 50, 0);
        EmptyBorder paddingScrean = new EmptyBorder(30, 0, 0, 0);

        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        JPanel screanLayoutPanel = new JPanel();
        screanLayoutPanel.setLayout(new BoxLayout(screanLayoutPanel, BoxLayout.Y_AXIS));
        screanLayoutPanel.setBorder(paddingScrean);

        JPanel messagePanel = new JPanel(new FlowLayout());

        JPanel userDataPanel = new JPanel(new GridLayout(5,1));
        userDataPanel.setBorder(paddingUserData);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel raPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel entityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel areaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel projectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        messagePanel.add(message);
        
        namePanel.add(userNameLabel);
        raPanel.add(userRaLabel);
        entityPanel.add(userEntityLabel);
        areaPanel.add(userAreaLabel);
        projectPanel.add(userProjectLabel);

        userDataPanel.add(namePanel);
        userDataPanel.add(nameData);
        userDataPanel.add(raPanel);
        userDataPanel.add(raData);
        userDataPanel.add(entityPanel);
        userDataPanel.add(entityData);
        userDataPanel.add(areaPanel);
        userDataPanel.add(areaData);
        userDataPanel.add(projectPanel);
        userDataPanel.add(projectData);

        buttonsPanel.add(registerHourButton);
        buttonsPanel.add(showHourButton);

        screanLayoutPanel.add(messagePanel);
        screanLayoutPanel.add(userDataPanel);
        screanLayoutPanel.add(buttonsPanel);

        caixa.add(screanLayoutPanel);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
