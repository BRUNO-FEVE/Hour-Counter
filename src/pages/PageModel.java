package pages;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PageModel {
    
    public String superTitle;
    public JPanel caixa;

    public PageModel(String superString, JPanel caixa) {
        super();
        this.superTitle = superString;
        this.caixa = caixa;
    }

    public JPanel getScreanContent() {
        return this.caixa;
    }
}
