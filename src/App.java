import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import components.PageModel;
import pages.HourViewPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.StopwatchPage;
import pages.UserMenuPage;

public class App extends  JFrame implements ActionListener{

    public String title = "Login";

    public JPanel content, loginPanel, registerPanel, menuPanel, hourViewPanel, stopWatchPanel;
    public Container caixa;
    public JMenuBar menuBar;

    private ArrayList<Object[]> data = new ArrayList<>();
    private ArrayList<Object[]> hourData = new ArrayList<>();
    private ArrayList<PageModel> lastPages = new ArrayList<>();
    private Object[] userData;

    private Object[] userTest = new Object[] {
        "Bruno Augusto Lopes Fevereiro",
        "123",
        "Dev. Community Mauá",
        "Front-End",
        "Portal Interno",
        "123", 
    };

    public LoginPage loginContent;
    public RegisterPage registerContent;
    public UserMenuPage menuContent;
    public HourViewPage hourViewContent;
    public StopwatchPage stopWatchContent;

    public App () {
        setTitle(title);

        caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        loginContent = new LoginPage();
        registerContent = new RegisterPage();
        menuContent = new UserMenuPage();
        hourViewContent = new HourViewPage();
        stopWatchContent = new StopwatchPage();

        loginPanel = new JPanel();
        registerPanel = new JPanel();
        menuPanel = new JPanel();
        hourViewPanel = new JPanel();
        stopWatchPanel = new JPanel();

        loginPanel.add(loginContent.getScreanContent());
        registerPanel.add(registerContent.getScreanContent());
        menuPanel.add(menuContent.getScreanContent());
        hourViewPanel.add(hourViewContent.getScreanContent());
        stopWatchPanel.add(stopWatchContent.getScreanContent());

        loginContent.registerButton.addActionListener(this);
        loginContent.loginButton.addActionListener(this);
        registerContent.registerButton.addActionListener(this);
        menuContent.showHourButton.addActionListener(this);
        menuContent.registerHourButton.addActionListener(this);
        stopWatchContent.buttonEnviar.addActionListener(this);

        menuContent.exit.addActionListener(this);
        hourViewContent.exit.addActionListener(this);
        stopWatchContent.exit.addActionListener(this);

        menuContent.back.addActionListener(this);
        hourViewContent.back.addActionListener(this);
        stopWatchContent.back.addActionListener(this);

        menuContent.createHours.addActionListener(this);
        menuContent.viewHour.addActionListener(this);

        hourViewContent.createHours.addActionListener(this);
        hourViewContent.menu.addActionListener(this);

        stopWatchContent.menu.addActionListener(this);
        stopWatchContent.viewHour.addActionListener(this);

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
        if (page == hourViewContent) {
            hourViewContent.setUserData(this.hourData, this.userData);
        }

        this.lastPages.add(page);
        System.out.println(lastPages);
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

        // Login Page Actions

        if (e.getSource() == loginContent.getRegisterButton()) {
            this.updatePage(registerContent);
            loginContent.cleanFields();
        } else if (e.getSource() == loginContent.getLoginButton()) {
            boolean isLogged = false;
            this.addUserToDataBase(this.userTest); // Test
            for (Object[] user : data) {
                if (loginContent.raField.getText().equals(user[1]) && new String(loginContent.passwordField.getPassword()).equals(user[5])) {
                    menuContent.setUserData(user);
                    this.userData = user;
                    this.updatePage(menuContent);
                    isLogged = true;

                    loginContent.cleanFields();
                } 
            }
            if (!isLogged) {
                JOptionPane.showMessageDialog(null, "Ra ou senha foram digitados errados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Register Page Actions 

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
                    this.updatePage(loginContent);
                    
                    registerContent.cleanFields();
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas digitadas são DIFERENTES!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Prencha TODOS os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Menu Page Actions 
        if (e.getSource() == menuContent.getHourViewButton()) {
            // Test
            Object[] userHourData = {5, "Reunião Planning", "01:50:00", "123"};
            this.hourData.add(userHourData);

            this.updatePage(hourViewContent);
        } else if (e.getSource() == menuContent.getRegisterButton()) {
            this.updatePage(stopWatchContent);
        }

        // StopWatch Actions 
        if (e.getSource() == stopWatchContent.getSendButton()) {
            if (!stopWatchContent.textFieldDescricao.getText().isEmpty()) {
                if (stopWatchContent.labelCronometro.equals("00:00:00")) {
                    Object[] newTask = {this.hourData.size()+1, stopWatchContent.textFieldDescricao.getText(), stopWatchContent.labelCronometro.getText(), this.userData[1]};
                    this.hourData.add(newTask);
                } else {
                    JOptionPane.showMessageDialog(null, "Tempo minimo não atingido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Prencha a DESCRIÇÃO os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Menu Bar
        if (e.getSource() == menuContent.getExitMenuItem() || e.getSource() == hourViewContent.getExitMenuItem() || e.getSource() == stopWatchContent.getExitMenuItem()) {
            this.updatePage(loginContent);
        } else if (e.getSource() == hourViewContent.getBackMenuItem() || e.getSource() == stopWatchContent.getBackMenuItem() || e.getSource() == menuContent.getBackMenuItem()) {
            this.updatePage(this.lastPages.get(this.lastPages.size()-2));
        }

        if (e.getSource() == menuContent.createHours || e.getSource() == hourViewContent.createHours) {
            this.updatePage(stopWatchContent);
        } else if (e.getSource() == menuContent.viewHour || e.getSource() == stopWatchContent.viewHour) {
            this.updatePage(hourViewContent);
        } else if (e.getSource() == hourViewContent.menu || e.getSource() == stopWatchContent.menu) {
            this.updatePage(menuContent);
        }

    }
}