import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import back.sql.ConectDB;
import back.sql.JDBC;
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

    public LoginPage loginContent;
    public RegisterPage registerContent;
    public UserMenuPage menuContent;
    public HourViewPage hourViewContent;
    public StopwatchPage stopWatchContent;

    public Connection conn = null;
    public ConectDB db;

    public App () throws SQLException {
        setTitle(title);

        // this.db = new ConectDB();
        // this.conn = db.conect();

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
            this.hourData.clear();

            JDBC hoursDataList = new JDBC(this.userData[1].toString());
            for (Object[] hour : hoursDataList.loadHours(conn)) {
                this.hourData.add(hour);
            }

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
            JDBC loginUser = new JDBC(loginContent.raField.getText(), new String(loginContent.passwordField.getPassword()));

            if (loginUser.loadLogin(conn)) {
                this.userData = new Object[] {loginUser.getName(), loginUser.getRa(), loginUser.getEntity(), loginUser.getArea(), loginUser.getProject(), loginUser.getId()};
                menuContent.setUserData(this.userData);
                this.updatePage(menuContent);
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou Ra incorretos!", "Aviso", JOptionPane.WARNING_MESSAGE);
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
                    
                    JDBC newUser = new JDBC(registerContent.getNewUser());
                    newUser.insertLogin(conn);

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
            this.updatePage(hourViewContent);
        } else if (e.getSource() == menuContent.getRegisterButton()) {
            this.updatePage(stopWatchContent);
        }

        // StopWatch Actions 
        if (e.getSource() == stopWatchContent.getSendButton()) {
            if (!stopWatchContent.textFieldDescricao.getText().isEmpty()) {
                if (true) {
                    JDBC newHour = new JDBC(this.userData[1].toString(), stopWatchContent.labelCronometro.getText(), stopWatchContent.textFieldDescricao.getText());
                    newHour.insertHours(conn);
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
