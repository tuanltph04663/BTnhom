package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConn;

public class LoginDAO {

    private static final Connection CONN = DBConn.getconnection();
    private static final String SELECT_WHERE = "SELECT * FROM loginfrom WHERE usename=? and password=?";

    public User authentication(String username, String password) {
        User user = new User();
        try {
            PreparedStatement stm = CONN.prepareStatement(SELECT_WHERE);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                user.setUserName(rs.getString("usename"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isQLSV(User user) {
        return "qlsv".equals(user.getRole());
    }

    public boolean isQLD(User user) {
        return "qld".equals(user.getRole());
    }
}
