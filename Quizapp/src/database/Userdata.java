package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DatabaseUtil;

public class Userdata {
	
	public boolean addUser(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseUtil.getConnection();
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());  
            stmt.setString(3, user.getRole());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        return false;
    }

    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT * FROM users WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
           
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(id, username, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return null;  
    }

  
    private void closeResources(Connection conn, PreparedStatement stmt) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            closeResources(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
