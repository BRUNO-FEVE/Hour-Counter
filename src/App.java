import pages.HourViewPage;

// import pages.LoginPage;
// import pages.RegisterPage;
// import pages.UserMenuPage;

public class App {
    public static void main(String[] args){
        // new RegisterPage();
        // new LoginPage();
        // new UserMenuPage();
        String[] columnNameList = {"id", "descrição", "duração"};
        Object[][] userData = {
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"},
            {5, "Reunião Planning", "01:30:00"}
        };

        new HourViewPage(columnNameList, userData, "00:00:00");
    }
}
