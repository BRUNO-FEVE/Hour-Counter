import java.awt.Container;

import javax.swing.JFrame;

import pages.LoginPage;
import pages.PageModel;

public class Application extends  JFrame{

    public Application (PageModel login) {
        super(login.superTitle);

        Container caixa = getContentPane();
        caixa.setLayout(login.PageLayout);

        caixa.add(login.getScreanContent());

        pack();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
