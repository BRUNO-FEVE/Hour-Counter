package pages;
import components.HourViewTableModel;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class HourViewPage extends JFrame{
    
    private JLabel totalHoursMessageLabel;

    public HourViewPage(String[] columnName, Object[][] userData, String totalHours) {
        super("Histório de Horas");

        totalHoursMessageLabel = new JLabel("Horas Totais: " + totalHours);

        // Layout
        EmptyBorder padding = new EmptyBorder(15, 0, 15, 0);
        totalHoursMessageLabel.setFont(totalHoursMessageLabel.getFont().deriveFont(36f));
        totalHoursMessageLabel.setBorder(padding);

        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        JPanel screanLayoutPanel = new JPanel();
        screanLayoutPanel.setLayout(new BoxLayout(screanLayoutPanel, BoxLayout.Y_AXIS));

        JTable hourHistoricTable = new JTable();
        hourHistoricTable.setModel(new HourViewTableModel(columnName, userData));
        // hourHistoricTable.set


        screanLayoutPanel.add(totalHoursMessageLabel);
        screanLayoutPanel.add(hourHistoricTable);

        caixa.add(screanLayoutPanel);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}