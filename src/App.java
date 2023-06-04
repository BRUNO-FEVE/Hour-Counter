import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.PageModel;
import pages.LoginPage;
import pages.RegisterPage;

public class App extends  JFrame implements ActionListener{

    public String title = "Login";
    public JPanel content, loginPanel, registerPanel;
    public Container caixa;

    public LoginPage loginContent;
    public RegisterPage registerContent;

    public App () {
        setTitle(title);

        caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        loginContent = new LoginPage();
        registerContent = new RegisterPage();

        loginPanel = new JPanel();
        registerPanel = new JPanel();

        loginPanel.add(loginContent.getScreanContent());
        registerPanel.add(registerContent.getScreanContent());

        loginContent.registerButton.addActionListener(this);

        this.content = loginPanel;

        caixa.add(content);

        setJMenuBar(loginContent.menuBar);

        pack();
        setLocationRelativeTo(null);
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void updatePage(String code) {
        if (code.equalsIgnoreCase("register")) {
            this.content = registerPanel;
        }
    }

    public void updateTitle(String title) {
        this.title = title;
        setTitle(title);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginContent.getRegisterButton()) {
            this.updateTitle("Registre-se");
            this.updatePage("register");

            this.caixa.removeAll();
            this.caixa.add(content);

            revalidate();
            repaint();
        }
    }
}