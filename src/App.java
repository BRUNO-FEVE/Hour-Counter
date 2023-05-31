import pages.HourViewPage;

// import pages.LoginPage;
// import pages.RegisterPage;
// import pages.UserMenuPage;

public class App {
    public static void main(String[] args){
        // new RegisterPage();
        // new LoginPage();
        // new UserMenuPage();
        String[] columnNameList = {"Id", "Descrição", "Duração"};
        Object[][] userData = {
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"}
        };

        new HourViewPage(columnNameList, userData, "40:00:00");
    }
}
