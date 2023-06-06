package components;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class HourViewTableModel extends AbstractTableModel {

    private String[] columnNames;
    private ArrayList<Object[]> userData;

    public HourViewTableModel(String[] columnName, ArrayList<Object[]> userData) {
        this.columnNames = columnName;
        this.userData = userData;
    }

    public int getRowCount() {
        return userData.size();
    }

    
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int row, int column) {
        Object[] rowData = userData.get(row);
        return rowData[column];
    }
    

}
