import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pages.LoginPage;
import pages.UserMenuPage;

public class Application extends  JFrame implements ActionListener{

    LoginPage login;
    UserMenuPage menu;

    Container caixa;

    public Application (LoginPage login, UserMenuPage menu) {
        super(login.superTitle);
        this.login = login;
        this.menu = menu;

        this.caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        caixa.add(this.login.getScreanContent());

        this.login.loginButton.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.loginButton) {
            this.caixa.removeAll();
            this.caixa.add(this.menu.getScreanContent());
            this.caixa.revalidate();
            this.caixa.repaint();
        }
    }
}
