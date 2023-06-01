package components;
import java.awt.Container;

import javax.swing.JPanel;

public class PageModel {
    
    public String superTitle;
    public Container caixa;

    public PageModel(String superString, Container caixa) {
        super();
        this.superTitle = superString;
        this.caixa = caixa;
    }

    public Container getScreanContent() {
        return this.caixa;
    }
}
