package spotlight;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */

public class PostModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    
    public PostModel(){}
    
    public PostModel(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    
    @SuppressWarnings("override")
    public Class getColumnClass(int column){
// 
        if(column == 0){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
    

    @Override
    public int getRowCount() {
     return this.rows.length;
    }

    
    @Override
    public int getColumnCount() {
     return this.columns.length;
    }

    
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    return this.rows[rowIndex][columnIndex];
    }
   
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }


}