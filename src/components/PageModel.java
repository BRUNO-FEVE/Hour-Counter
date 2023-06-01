package components;
import java.awt.Container;
import java.awt.LayoutManager;


public class PageModel {
    
    public static final LayoutManager PageLayout = null;
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
