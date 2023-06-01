import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pages.LoginPage;
import pages.PageModel;

public class Application extends  JFrame{

    public Application (PageModel login) {
        super(login.superTitle);

        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        caixa.add(login.getScreanContent());

        pack();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
