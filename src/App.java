import javax.swing.JPanel;

import pages.HourViewPage;

import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class App {
    public static void main(String[] args){
        //new RegisterPage();
        //LoginPage login = new LoginPage();
        //login.openTheLoginPage();
        //new UserMenuPage();
        String[] columnNameList = {"Id", "Descrição", "Duração"};
        Object[][] userData = {
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"}
        };
        
        JPanel caixa = new JPanel();
        LoginPage login = new LoginPage("Login", caixa);
        UserMenuPage menu = new UserMenuPage("Menu", caixa);
        

        new Application(login);

        //new HourViewPage(columnNameList, userData, "40:00:00");
    }
}
