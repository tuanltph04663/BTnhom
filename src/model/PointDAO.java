package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PointDAO extends DAO<Point> {

    private static final String SELECT_ALL = "SELECT * FROM POINT";
    private static final String SELECT_WHERER = "SELECT * FROM POINT WHERE STUDENT_CODE like ?";
    private static final String INSERT_INTO = "INSERT INTO POINT VALUES(?,?,?,?,?)";
    private static final String UPDATE_WHERE = "UPDATE POINT SET FULL_NAME=?, ENGLISH=?, INFORMATICS=?, PHYSICAL_EDUCATION=? WHERE STUDENT_CODE=?";
    private static final String DELETE_WHERE = "DELETE POINT WHERE STUDENT_CODE=?";

    @Override
    public void add(Point e) {
        String studentCode = e.getStudentCode();
        String fullName = e.getFullName();

        double english = e.getEnglish();
        double informatics = e.getInformatics();
        double physicalEducation = e.getPhysicalEducation();

        try {
            PreparedStatement p = CONN.prepareStatement(INSERT_INTO);
            p.setString(1, studentCode);
            p.setString(2, fullName);

            p.setDouble(3, english);
            p.setDouble(4, informatics);
            p.setDouble(5, physicalEducation);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Point e) {
        String studentCode = e.getStudentCode();
        String fullName = e.getFullName();

        double english = e.getEnglish();
        double informatics = e.getInformatics();
        double physicalEducation = e.getPhysicalEducation();

        try {
            PreparedStatement p = CONN.prepareStatement(UPDATE_WHERE);
            p.setString(1, fullName);
            p.setDouble(2, english);
            p.setDouble(3, informatics);
            p.setDouble(4, physicalEducation);
            p.setString(5, studentCode);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String studentCode) {
        try {
            PreparedStatement p = CONN.prepareStatement(DELETE_WHERE);
            p.setString(1, studentCode);

            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Hàm này lấy tất cả bản ghi trong bảng grade
     *
     * @return
     *
     * List<Point>
     */
    @Override
    public List<Point> getAll() {
        List<Point> points = new ArrayList<>();
        try {
            Statement stm = CONN.createStatement();
            ResultSet rs = stm.executeQuery(SELECT_ALL);
            while (rs.next()) {
                String studentCode = rs.getString("STUDENT_CODE");
                String fullName = rs.getString("FULL_NAME");
                double english = rs.getDouble("ENGLISH");
                double informatics = rs.getDouble("INFORMATICS");
                double physicalEducation = rs.getDouble("PHYSICAL_EDUCATION");

                Point p = new Point(studentCode, fullName, english, informatics, physicalEducation);
                points.add(p);
            }
            return points;
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Point findBy(String id) {
        Point point = new Point();

        try {
            PreparedStatement p = CONN.prepareStatement(SELECT_WHERER);
            p.setString(1, id);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                // TODO get data here
            }
            return point;
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Point> search(String id) {
        List<Point> points = new ArrayList<>();

        try {
            PreparedStatement p = CONN.prepareStatement(SELECT_WHERER);
            p.setString(1, id);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                // TODO get data here
                String studentCode = rs.getString("STUDENT_CODE");
                String fullName = rs.getString("FULL_NAME");
                double english = rs.getDouble("ENGLISH");
                double informatics = rs.getDouble("INFORMATICS");
                double physicalEducation = rs.getDouble("PHYSICAL_EDUCATION");

                Point point = new Point(studentCode, fullName, english, informatics, physicalEducation);
                points.add(point);
            }
            return points;
        } catch (SQLException ex) {
            Logger.getLogger(PointDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
