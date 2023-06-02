import javax.swing.JPanel;

import pages.LoginPage;
import pages.RegisterPage;
import pages.UserMenuPage;

public class Test {
    public static void main(String[] args){
        //new RegisterPage();
        //LoginPage login = new LoginPage();
        //login.openTheLoginPage();
        //new UserMenuPage();
        //String[] columnNameList = {"Id", "Descrição", "Duração"};
        //Object[][] userData = {
        //   {5, "Reunião Planning", "01:30:00"},
        //   {5, "Reunião Planning", "01:30:00"},
        //    {5, "Reunião Planning", "01:30:00"}
        //};
        
        JPanel caixa = new JPanel();

        LoginPage login = new LoginPage("Login", caixa);
        UserMenuPage menu = new UserMenuPage("Menu", caixa);
        RegisterPage register = new RegisterPage("Registri-se", caixa);
        
        //new App(login);

        //new Application(login, menu, register);

        //new HourViewPage(columnNameList, userData, "40:00:00");
    }
}
