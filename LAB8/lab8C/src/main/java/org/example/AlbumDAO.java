package org.example;
import java.sql.*;

public class AlbumDAO {
    public void create(Integer year, String name, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO albums(release_year, name, artist_id, genre_id) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, name);
            pstmt.setInt(3, new ArtistDAO().findByName(artist));
            pstmt.setInt(4, new GenreDAO().findByName(genre));
            pstmt.executeUpdate();
        }
    }

    public void printAll() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM albums")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getInt("release_year") + " " + rs.getString("name") + " " + new ArtistDAO().findById(rs.getInt("artist_id")) + " " + new GenreDAO().findById(rs.getInt("genre_id")));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }
}