package components;

import javax.swing.table.AbstractTableModel;

public class HourViewTableModel extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] userData;

    public HourViewTableModel(String[] columnName, Object[][] userData) {
        this.columnNames = columnName;
        this.userData = userData;
    }

    public int getRowCount() {
        return userData.length;
    }

    
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rows, int columns) {
        return userData[rows][columns];
    }

}
