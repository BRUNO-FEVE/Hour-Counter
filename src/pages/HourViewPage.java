package pages;
import components.HourViewTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class HourViewPage extends JFrame{
    
    private JLabel totalHoursMessageLabel, tabelMassageLabel, totalHoursLabel;

    public HourViewPage(String[] columnName, Object[][] userData, String totalHours) {
        super("Histório de Horas");

        totalHoursMessageLabel = new JLabel("Horas Totais: ");
        tabelMassageLabel = new JLabel("Suas ultimas Tarefas:");
        totalHoursLabel = new JLabel(totalHours);

        // Layout

        // Font Size
        totalHoursMessageLabel.setFont(totalHoursMessageLabel.getFont().deriveFont(36f));
        totalHoursLabel.setFont(totalHoursMessageLabel.getFont().deriveFont(36f));

        // Font Color 
        if (Integer.parseInt(totalHours.substring(0, 2)) > 39) {
            totalHoursLabel.setForeground(Color.decode("#31572c"));
        } else {
            totalHoursLabel.setForeground(Color.decode("#c1121f"));
        }

        // Margin 
        totalHoursMessageLabel.setBorder(new EmptyBorder(15, 0, 15, 0));
        tabelMassageLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());

        JPanel screanLayoutPanel = new JPanel();
        screanLayoutPanel.setLayout(new BoxLayout(screanLayoutPanel, BoxLayout.Y_AXIS));

        JPanel totalHourPanel = new JPanel();
        totalHourPanel.setLayout(new FlowLayout());

        JTable hourHistoricTable = new JTable();
        hourHistoricTable.setModel(new HourViewTableModel(columnName, userData));

        

        totalHourPanel.add(totalHoursMessageLabel);
        totalHourPanel.add(totalHoursLabel);

        screanLayoutPanel.add(totalHourPanel);
        screanLayoutPanel.add(tabelMassageLabel);
        screanLayoutPanel.add(hourHistoricTable);

        caixa.add(screanLayoutPanel);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}