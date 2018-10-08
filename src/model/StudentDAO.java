package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.CONN;

public class StudentDAO extends DAO<Student> {

    private static final String SELECT_ALL = "SELECT * FROM STUDENT";
    private static final String INSERT_INTO = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_WHERE = "UPDATE STUDENT SET FULL_NAME=?,EMAIL=?,PHONE_NUMBER=?,GENDER=?,ADDRESS=?,IMAGE=? WHERE STUDENT_CODE=?";
    private static final String DELETE_WHERE = "DELETE STUDENT WHERE STUDENT_CODE=?";
    
    @Override
    public void add(Student e) {
        String studentCode = e.getStudentCode();
        String fullName = e.getFullName();
        String email = e.getEmail();
        String phoneNumber = e.getPhoneNumber();
        String gender = e.getGender();
        String address = e.getAddress();
        String image = e.getImage();

        try {
            PreparedStatement p = CONN.prepareStatement(INSERT_INTO);

            p.setString(1, studentCode);
            p.setString(2, fullName);
            p.setString(3, email);
            p.setString(4, phoneNumber);
            p.setString(5, gender);
            p.setString(6, address);
            p.setString(7, image);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student e) {
        String studentCode = e.getStudentCode();
        String fullName = e.getFullName();
        String email = e.getEmail();
        String phoneNumber = e.getPhoneNumber();
        String gender = e.getGender();
        String address = e.getAddress();
        String image = e.getImage();

        try {
            PreparedStatement p = CONN.prepareStatement(UPDATE_WHERE);

            p.setString(1, fullName);
            p.setString(2, email);
            p.setString(3, phoneNumber);
            p.setString(4, gender);
            p.setString(5, address);
            p.setString(6, image);
            p.setString(7, studentCode);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String studentCode) {
        try {
            PreparedStatement p = CONN.prepareStatement(DELETE_WHERE);
            p.setString(1, studentCode);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement stm = CONN.createStatement();
            ResultSet rs = stm.executeQuery(SELECT_ALL);
            while (rs.next()) {
                String studentCode = rs.getString("STUDENT_CODE");
                String fullName = rs.getString("FULL_NAME");
                String email = rs.getString("EMAIL");
                String phoneNumber = rs.getString("PHONE_NUMBER");
                String gender = rs.getString("GENDER");
                String address = rs.getString("ADDRESS");
                String image = rs.getString("IMAGE");

                Student s = new Student(studentCode, fullName, email, phoneNumber, gender, address, image);
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student findBy(String code) {
        // TODO find Student by code
        return null;
    }

}
