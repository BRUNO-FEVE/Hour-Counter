import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import components.PageModel;

public class App extends  JFrame{

    public App (PageModel login) {
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