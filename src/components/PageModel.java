package components;
import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class PageModel {
    
    public String superTitle;
    public Container caixa;
    public JMenuBar menuBar;

    public PageModel(String superString, Container caixa) {
        super();
        this.superTitle = superString;
        this.caixa = caixa;

        menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("Menu");

        JMenuItem back = new JMenuItem("Voltar");
        JMenuItem exit = new JMenuItem("Sair");

        fileMenu.add(back);
        fileMenu.add(exit);

        menuBar.add(fileMenu);
    }

    public Container getScreanContent() {
        return this.caixa;
    }
}
