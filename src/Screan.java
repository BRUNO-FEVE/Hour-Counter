import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pages.HourViewPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.StopwatchPage;
import pages.UserMenuPage;

public class Screan {
    public static void main(String[] args) {

        App telaLogin, telaMenu, telaRegister;

        String[] userData = new String[6];
        
        JPanel caixaLogin = new JPanel();
        JPanel caixaMenu = new JPanel();
        JPanel caixaRegister = new JPanel();
        JPanel caixaHourView = new JPanel();
        JPanel caixaStopWatch = new JPanel();

        LoginPage login = new LoginPage("Login", caixaLogin);
        
        RegisterPage register = new RegisterPage("Registri-se", caixaRegister);

        String[] columnNameList = {"Id", "Descrição", "Duração"};
        Object[][] userHourData = {
            {5, "Reunião Planning", "01:50:00"},
            {5, "Reunião Planning", "01:55:00"},
            {5, "Reunião Planning", "01:40:00"}
        };

        telaLogin = new App(login);


        telaRegister = new App(register);
        telaRegister.setVisible(false);

        login.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (true) {
                    telaLogin.setVisible(false);

                    UserMenuPage menu = new UserMenuPage("Menu", caixaMenu, userData);
                    App telaMenu = new App(menu);

                    menu.showHourButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            telaMenu.setVisible(false);

                            HourViewPage hourList = new HourViewPage(columnNameList, userHourData, "Ultimas atividades", caixaHourView);
                            App telaHourView = new App(hourList);
                        }
                    });

                    menu.registerHourButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            telaMenu.setVisible(false);
                            
                            StopwatchPage stopwatch = new StopwatchPage("Registrar Horas", caixaStopWatch);
                            App telaStopWatch = new App(stopwatch);
                        }
                    });
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
                    userData[4] = register.areaField.getText();
                    userData[5] = register.projectField.getText();

                    register.nameField.setText("");
                    register.raField.setText("");
                    register.entityField.setText("");
                    register.areaField.setText("");
                    register.projectField.setText("");
                    register.passwordField.setText("");
                    register.confirmField.setText("");

                    

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

        
        // menu.showHourButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         if(true) {

        //             telaMenu.setVisible(false);
        //         }
        //     }
        // });

        





        

    }
}
