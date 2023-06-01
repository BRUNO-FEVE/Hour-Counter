import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class Main extends JFrame implements ActionListener{

    public LoginPage login;
    public UserMenuPage menu;

    private Application app;

    
    public Main() {

        Container caixa = getContentPane();

        //login = new LoginPage("Login", caixa, true);
        //menu = new UserMenuPage("Menu", caixa, false);
        RegisterPage register = new RegisterPage("Registri-se",  caixa, false);

        //new Application(login);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.loginButton) {

        }

    }
}
