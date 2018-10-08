package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Point;

/**
 *
 * @author RZ09
 */
public class QuanLyDiemController {
    
    public void filToTable(List<Point> list, JTable tb){
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        for (Point p : list) {
            Object[] row = new Object[] { p.getStudentCode(), p.getFullName(), p.getEnglish(), p.getInformatics(), p.getPhysicalEducation(), p.getAverage()};
            model.addRow(row);
        }
    }
    
    
    
}
