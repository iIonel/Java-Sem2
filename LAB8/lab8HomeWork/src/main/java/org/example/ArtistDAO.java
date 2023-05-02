package org.example;
import java.sql.*;

public class ArtistDAO{
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO artists(name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public  Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM artists WHERE name = '" + name + "'")) {
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
             ResultSet rs = stmt.executeQuery("SELECT name FROM artists WHERE id = " + id)) {
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