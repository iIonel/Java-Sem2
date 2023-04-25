package org.example;
import java.sql.*;
public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO genres(name) VALUES (?) ON CONFLICT (name) DO NOTHING")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public  Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM genres WHERE name = '" + name + "'")) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
    public String findById(Integer id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM genres WHERE id = " + id)) {
            if (rs.next()) {
                return rs.getString("name");
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}