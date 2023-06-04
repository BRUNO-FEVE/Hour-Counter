import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import components.PageModel;
import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class App extends  JFrame implements ActionListener{

    public String title = "Login";
    public JPanel content, loginPanel, registerPanel, menuPanel;
    public Container caixa;
    public JMenuBar menuBar;

    private Object[][] data = {
        {
            "Bruno Augusto Lopes Fevereiro",
            "20.02194-0",
            "Dev. Community Mauá",
            "Front-End",
            "Portal Interno",
            "123"
        }, 
        {
            "Bruno Augusto Lopes Fevereiro",
            "123",
            "Dev. Community Mauá",
            "Front-End",
            "Portal Interno",
            "123"
        }
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
            for (Object[] objects : data) {
                if (loginContent.raField.getText().equals(objects[1]) && loginContent.passwordField.getText().equals(objects[5])) {
                    menuContent.setUserData(objects);
                    this.updatePage(menuContent);
                    isLogged = true;
                } 
            }
            if (!isLogged) {
                JOptionPane.showMessageDialog(null, "Ra ou senha foram digitados errados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }


    }
}