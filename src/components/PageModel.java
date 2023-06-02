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
        JMenu pagesMenu = new JMenu("Paginas");

        JMenuItem back = new JMenuItem("Voltar");
        JMenuItem exit = new JMenuItem("Sair");

        JMenuItem menu = new JMenuItem("Menu");
        JMenuItem viewHour = new JMenuItem("Histórico");
        JMenuItem createHours = new JMenuItem("Salvar Horas");

        fileMenu.add(back);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        pagesMenu.add(menu);
        pagesMenu.add(viewHour);
        pagesMenu.add(createHours);
        
        menuBar.add(fileMenu);
        menuBar.add(pagesMenu);
    }

    public Container getScreanContent() {
        return this.caixa;
    }
}
