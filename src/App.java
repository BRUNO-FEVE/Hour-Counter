import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

import components.PageModel;
import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class App extends  JFrame implements ActionListener{

    public String title = "Login";
    public JPanel content, loginPanel, registerPanel, menuPanel;
    public Container caixa;
    public JMenuBar menuBar;

    private ArrayList<Object[]> data = new ArrayList<>();

    private Object[] userTest = new Object[] {
        "Bruno Augusto Lopes Fevereiro",
        "123",
        "Dev. Community Mauá",
        "Front-End",
        "Portal Interno",
        "123"
    };

    public LoginPage loginContent;
    public RegisterPage registerContent;
    public UserMenuPage menuContent;

    public App () {
        setTitle(title);

        caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        loginContent = new LoginPage();
        registerContent = new RegisterPage();
        menuContent = new UserMenuPage();

        loginPanel = new JPanel();
        registerPanel = new JPanel();
        menuPanel = new JPanel();

        loginPanel.add(loginContent.getScreanContent());
        registerPanel.add(registerContent.getScreanContent());
        menuPanel.add(menuContent.getScreanContent());

        loginContent.registerButton.addActionListener(this);
        loginContent.loginButton.addActionListener(this);
        registerContent.registerButton.addActionListener(this);

        this.content = loginPanel;
        caixa.add(content);

        this.menuBar = loginContent.menuBar;
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addUserToDataBase(Object[] newUser) {
        data.add(newUser);
    }

    public void updatePage(PageModel page) {
        this.content = page.getScreanContent();
        this.menuBar = page.menuBar;
        this.title = page.superTitle;
        
        this.caixa.removeAll();
        this.caixa.add(content);

        setTitle(title);
        setJMenuBar(menuBar);

        revalidate();
        repaint();
    }

    public void updateTitle(String title) {
        this.title = title;
        setTitle(this.title);
    }

    public void updateMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
        setJMenuBar(this.menuBar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginContent.getRegisterButton()) {
            this.updatePage(registerContent);

        } else if (e.getSource() == loginContent.getLoginButton()) {
            boolean isLogged = false;
            this.addUserToDataBase(this.userTest); // Test
            for (Object[] user : data) {
                if (loginContent.raField.getText().equals(user[1]) && new String(loginContent.passwordField.getPassword()).equals(user[5])) {
                    menuContent.setUserData(user);
                    this.updatePage(menuContent);
                    isLogged = true;
                } 
            }
            if (!isLogged) {
                JOptionPane.showMessageDialog(null, "Ra ou senha foram digitados errados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == registerContent.getRegisterButton()) {
            boolean hasName = !registerContent.nameField.getText().isEmpty();
            boolean hasRa = !registerContent.raField.getText().isEmpty();
            boolean hasEntity = !registerContent.entityField.getText().isEmpty();
            boolean hasArea = !registerContent.areaField.getText().isEmpty();
            boolean hasProject = !registerContent.projectField.getText().isEmpty();
            boolean hasPassword = new String(registerContent.passwordField.getPassword()).length() > 0;
            boolean hasConfirmed = new String(registerContent.confirmField.getPassword()).length() > 0;            

            if (hasName && hasRa && hasEntity && hasArea && hasProject && hasPassword && hasConfirmed) {
                if (new String(registerContent.passwordField.getPassword()).equals(new String(registerContent.confirmField.getPassword()))) {
                    this.addUserToDataBase(registerContent.getNewUser());
                    System.out.println(Arrays.toString(registerContent.getNewUser()));
                    this.updatePage(loginContent);
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas digitadas são DIFERENTES!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Prencha TODOS os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}