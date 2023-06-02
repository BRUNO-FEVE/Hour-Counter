import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class Screan {
    public static void main(String[] args) {

        App telaLogin, telaMenu, telaRegister;

        String[] userData = new String[5];
        
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
        
        register.registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (register.passwordField.getText().equals(register.confirmField.getText())) {

                    userData[0] = register.passwordField.getText();
                    userData[1] = register.nameField.getText();
                    userData[2] = register.raField.getText();
                    userData[3] = register.entityField.getText();
                    userData[4] = register.projectField.getText();

                    JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                    telaRegister.setVisible(false);
                    telaLogin.setVisible(true);
                } else if (register.passwordField.getText().isBlank() || register.confirmField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Prencha todos os campos!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Senhas digitas são diferentes!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        

    }
}
