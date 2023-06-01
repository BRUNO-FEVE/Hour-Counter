package pages;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PageModel {
    
    public String superTitle;
    public JPanel caixa;
    public BorderLayout PageLayout = new BorderLayout(10, 10);

    public PageModel(String superString, JPanel caixa) {
        super();
        this.superTitle = superString;
        this.caixa = caixa;
    }

    public JPanel getScreanContent() {
        return this.caixa;
    }
}
