import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class Screan {
    public static void main(String[] args) {

        App telaLogin, telaMenu, telaRegister;
        
        JPanel caixaLogin = new JPanel();
        JPanel caixaMenu = new JPanel();
        JPanel caixaRegister = new JPanel();

        LoginPage login = new LoginPage("Login", caixaLogin);
        UserMenuPage menu = new UserMenuPage("Menu", caixaMenu);
        RegisterPage register = new RegisterPage("Registri-se", caixaRegister);


        telaLogin = new App(login);

        telaMenu = new App(menu);
        telaMenu.setVisible(false);

        telaRegister = new App(register);
        telaRegister.setVisible(false);

        login.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (true) {
                    telaLogin.setVisible(false);
                    telaMenu.setVisible(true);
                }
            }
        });

        login.registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (true) {
                    telaLogin.setVisible(false);
                    telaRegister.setVisible(true);
                }
            }
        });



        

    }
}
