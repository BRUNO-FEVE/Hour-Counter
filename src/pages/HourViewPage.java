package pages;
import components.HourViewTableModel;
import components.PageModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;


public class HourViewPage extends PageModel{
    
    private JLabel totalHoursMessageLabel, tabelMassageLabel, totalHoursLabel, redLabel, greenLabel;
    private DefaultTableCellRenderer centerRender;

    public JTable hourHistoricTable;
    public String[] columnName = {"Id", "Descrição", "Duração"};

    private ArrayList<Object[]> tableData = new ArrayList<>();

    public HourViewPage() {
        super.superTitle = "Histórico";

        totalHoursMessageLabel = new JLabel("Horas Totais: ");
        tabelMassageLabel = new JLabel("Suas ultimas Tarefas:");

        
        System.out.println(totalHoursLabel);

        greenLabel = new JLabel("Voçê NÃO atingiu as horas neccessarias");
        redLabel = new JLabel("Voçê atingiu as horas neccessarias");

        // ------  Layout -------

        totalHoursLabel = new JLabel("");

        // Font Size
        totalHoursMessageLabel.setFont(totalHoursMessageLabel.getFont().deriveFont(36f));
        totalHoursLabel.setFont(totalHoursMessageLabel.getFont().deriveFont(36f));

        // Margin 
        totalHoursMessageLabel.setBorder(new EmptyBorder(15, 0, 15, 0));
        tabelMassageLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

        super.caixa.setLayout(new FlowLayout());

        JPanel screanLayoutPanel = new JPanel();
        screanLayoutPanel.setLayout(new BoxLayout(screanLayoutPanel, BoxLayout.Y_AXIS));

        JPanel totalHourPanel = new JPanel();
        totalHourPanel.setLayout(new FlowLayout());

        // Squares

        JPanel subtitles = new JPanel() {
            @Override
            public void paintComponent(Graphics graphic) {
                super.paintComponents(graphic);
                
                Graphics2D square = (Graphics2D) graphic;

                square.setColor(Color.decode("#31572c"));
                square.fill(new Rectangle2D.Double(85, 8, 10, 10));

                square.setColor(Color.decode("#c1121f"));
                square.fill(new Rectangle2D.Double(70, 29, 10, 10));

                square.dispose();
                graphic.dispose();
            }
        };
        subtitles.setLayout(new FlowLayout(FlowLayout.CENTER));
        subtitles.setPreferredSize(new Dimension(0, 50));
        subtitles.setBorder(new EmptyBorder(0, 10, 0, 0));

        JPanel tableTittle = new JPanel();
        tableTittle.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Table

        hourHistoricTable = new JTable(); 

        // Centering the Cells 

        
        centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        hourHistoricTable.setDefaultRenderer(String.class, centerRender);

        // Adding to the Panels

        totalHourPanel.add(totalHoursMessageLabel);
        totalHourPanel.add(totalHoursLabel);

        subtitles.add(redLabel);
        subtitles.add(greenLabel);

        tableTittle.add(tabelMassageLabel);

        screanLayoutPanel.add(totalHourPanel);
        screanLayoutPanel.add(subtitles);
        screanLayoutPanel.add(tableTittle);
        screanLayoutPanel.add(hourHistoricTable);

        super.caixa.add(screanLayoutPanel);
    }

    public void setTotalHours(ArrayList<Object[]> data) {
        int totalHour = 0;
        int totalMin = 0;
        int totalSec = 0;

        String hourString = "", minString = "", secString = "";

        for (Object[] task : data) {
            if (task != data.get(0)) {
                String[] times = task[2].toString().split(":");
            
                totalHour += Integer.parseInt(times[0]);
                totalMin += Integer.parseInt(times[1]);
                totalSec += Integer.parseInt(times[2]);
            }
        }

        if (totalSec > 60) {
            totalMin += totalSec / 60;
            totalSec %= 60;
        }

        if (totalMin > 60) {
            totalHour += totalMin / 60;
            totalMin %= 60;
        }

        if (totalSec < 10) {
            secString = "0" + totalSec;
        } else if (totalSec == 0) {
            secString = "00";
        } else {
            secString = String.valueOf(totalSec);
        }

        if (totalMin < 10) {
            minString = "0" + totalMin;
        } else if (totalMin == 0) {
            secString = "00";
        } else {
            minString = String.valueOf(totalMin);
        }
        
        if (totalHour < 10) {
            hourString = "0" + totalHour;
        } else if (totalHour == 0) {
            hourString = "00";
        } else {
            hourString = String.valueOf(totalHour);
        }

        totalHoursLabel.setText(hourString + ":"+ minString + ":" + secString);

        if (Integer.parseInt(String.valueOf(totalHour)) > 39) {
            totalHoursLabel.setForeground(Color.decode("#31572c"));
        } else {
            totalHoursLabel.setForeground(Color.decode("#c1121f"));
        }
    }

    public void setUserData(ArrayList<Object[]> data, Object[] user) {
        tableData.add(columnName);

        for (Object[] task : data) {
            if (task[3].equals(user[1])) {
                tableData.add(task);
            }
        }

        this.setTotalHours(tableData);
        this.hourHistoricTable.setModel(new HourViewTableModel(columnName, tableData));

        for (int i = 0; i < hourHistoricTable.getColumnCount(); i++) {
            hourHistoricTable.getColumnModel().getColumn(i).setCellRenderer(centerRender);
        }
    }

}