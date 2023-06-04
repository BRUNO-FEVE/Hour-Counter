package pages;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import components.PageModel;

public class UserMenuPage extends PageModel{
    
    private JLabel message, nameData, raData, entityData, areaData, projectData ,userNameLabel, userRaLabel, userEntityLabel, userAreaLabel, userProjectLabel;
    public JButton registerHourButton, showHourButton;

    public boolean visible;
    public String[] dataList= new String[6];

    public UserMenuPage() {
        super.superTitle = "Menu";

        message = new JLabel("Seus Dados:");
        userNameLabel = new JLabel("Nome:");
        userRaLabel = new JLabel("RA:");
        userEntityLabel = new JLabel("Entidade:");
        userAreaLabel = new JLabel("Área:");
        userProjectLabel = new JLabel("Projeto:");

        nameData = new JLabel(dataList[1]);
        raData = new JLabel(dataList[2]);
        entityData = new JLabel(dataList[3]);
        areaData = new JLabel(dataList[4]);
        projectData = new JLabel(dataList[5]);

        registerHourButton = new JButton("Registrar Horas");
        showHourButton = new JButton("Visualizar Horas");

        // Layout

        EmptyBorder paddingUserData = new EmptyBorder(10, 30, 50, 0);
        EmptyBorder paddingScrean = new EmptyBorder(30, 0, 0, 0);

        super.caixa.setLayout(new BorderLayout(10, 10));

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

        super.caixa.add(screanLayoutPanel);
    }

    public boolean setVisible(boolean visible) {
        return this.visible = visible;
    }

    public void setUserData(String[] dataList) {
        this.dataList = dataList;
    }
}
