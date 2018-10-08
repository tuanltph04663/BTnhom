package controller;

import app.QuanLySinhVien;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Student;
import util.CopyFile;

/**
 *
 * @author RZ09
 */
public class QuanLySinhVienController {

    public void fillToTable(List<Student> list, JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        for (Student s : list) {
            Object[] row = new Object[]{
                s.getStudentCode(),
                s.getFullName(),
                s.getEmail(),
                s.getPhoneNumber(),
                s.getGender(),
                s.getAddress(),
                s.getImage()
            };
            model.addRow(row);
        }
    }

    public String browserImage(String savePath) {
        JFileChooser jFileChooser = new JFileChooser();
        int returnVal = jFileChooser.showOpenDialog(null);
        File file;
        String sourcePath;
        String imageName = "100x150.png";

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            sourcePath = file.getAbsolutePath();
            imageName = file.getName();

            CopyFile cf = new CopyFile();
            try {
                cf.copyFile(sourcePath, savePath, imageName);
            } catch (IOException ex) {
                Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println(imageName);
        return imageName;
    }

}
